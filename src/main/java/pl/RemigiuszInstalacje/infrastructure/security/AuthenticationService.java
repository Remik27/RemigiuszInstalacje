package pl.RemigiuszInstalacje.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.RemigiuszInstalacje.api.dto.mapper.CustomerMapper;
import pl.RemigiuszInstalacje.business.CustomerService;
import pl.RemigiuszInstalacje.domain.Customer;
import pl.RemigiuszInstalacje.domain.exception.ResourceNotExistException;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.AuthenticateRequest;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.AuthenticationResponse;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.RegisterRequest;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.mapper.UserMapper;
import pl.RemigiuszInstalacje.infrastructure.security.db.entity.UserEntity;
import pl.RemigiuszInstalacje.infrastructure.security.db.repository.RoleRepository;
import pl.RemigiuszInstalacje.infrastructure.security.db.repository.UserRepository;
import pl.RemigiuszInstalacje.infrastructure.security.domain.Roles;
import pl.RemigiuszInstalacje.infrastructure.security.token.JwtService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final CustomerService customerService;
    private final UserMapper userMapper;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    public AuthenticationResponse authenticate(AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getUsername(),
                        authenticateRequest.getPassword()
                )
        );
        UserEntity user = userRepository.findByUsername(authenticateRequest.getUsername()).orElseThrow(
                () -> new ResourceNotExistException("User [%s] not found".formatted(authenticateRequest.getUsername())));
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        UserEntity user = userMapper.mapFromRegister(registerRequest);
        userRepository.saveAndFlush(
                user
                        .withActive(true)
                        .withRoles(Set.of(roleRepository.findByRole(Roles.CUSTOMER.name()).get())));
        Customer customer = customerMapper.mapFromRegister(registerRequest);
        customerService.saveCustomer(customer);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
