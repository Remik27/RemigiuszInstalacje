package pl.RemigiuszInstalacje.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.RemigiuszInstalacje.domain.exception.ResourceNotExistException;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.AuthenticateRequest;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.AuthenticationResponse;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.RegisterRequest;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.mapper.UserMapper;
import pl.RemigiuszInstalacje.infrastructure.security.db.entity.UserEntity;
import pl.RemigiuszInstalacje.infrastructure.security.db.repository.UserRepository;
import pl.RemigiuszInstalacje.infrastructure.security.token.JwtService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse authenticate(AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getUsername(),
                        authenticateRequest.getPassword()
                )
        );
        UserEntity user = repository.findByUsername(authenticateRequest.getUsername()).orElseThrow(
                () -> new ResourceNotExistException("User [%s] not found".formatted(authenticateRequest.getUsername())));
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        UserEntity user = mapper.mapFromRegister(registerRequest);
        repository.saveAndFlush(user.withActive(true));
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
