package com.devtiro.blog.users;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserService {

    UserDetails loadUserByUsername(String username);
    User getUserById(UUID id);
}
