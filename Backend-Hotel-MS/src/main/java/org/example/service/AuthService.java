package org.example.service;

import org.example.request.LoginRequest;
import org.example.response.JwtResponse;

public interface AuthService {
    JwtResponse authenticateUser(LoginRequest loginRequest);
}
