package com.shravan.AuthSecurity.dto.auth;

public record RegisterResponse(
        Long id,
        String name,
        String email
) {
}
