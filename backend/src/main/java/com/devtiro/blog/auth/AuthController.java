package com.devtiro.blog.auth;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        UserDetails user = authenticationService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        var authResponse = AuthResponse.builder()
                .token(authenticationService.generateToken(user))
                .expiresIn(86400)
                .build();

        return ResponseEntity.ok(authResponse);
    }

}
