package com.devtiro.blog.auth;

import com.devtiro.blog.users.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final AuthenticationManager manager;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest loginRequest){
        var authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        var authentication = manager.authenticate(authenticationToken);

        var user = (User) authentication.getPrincipal();

        var authResponse = AuthResponse.builder()
                .token(authenticationService.generateToken(user))
                .expiresIn(86400)
                .build();

        return ResponseEntity.ok(authResponse);
    }

}
