package com.keralty.aesolicitudes.security;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;

import com.keralty.aesolicitudes.viewmodel.LoginRequest;

@ApplicationScoped
public interface UserAuthenticationService {

    Optional<String> login(String username, String password);
    
    Optional<String> login(LoginRequest loginRequest);

    void logout(User user);
}
