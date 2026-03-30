package com.shravan.AuthSecurity.service;

import com.shravan.AuthSecurity.dto.auth.RegisterRequest;
import com.shravan.AuthSecurity.dto.auth.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
}
