package pl.RemigiuszInstalacje.infrastructure.security.api.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.RemigiuszInstalacje.infrastructure.security.AuthenticationService;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.AuthenticateRequest;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.AuthenticationResponse;
import pl.RemigiuszInstalacje.infrastructure.security.api.dto.RegisterRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ){
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticateRequest authenticateRequest
    ){
        return ResponseEntity.ok(authenticationService.authenticate(authenticateRequest));
    }
}
