package com.devtiro.blog.auth;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {

    String generateToken(UserDetails userDetails);

    UserDetails validateToken(String token);
}
