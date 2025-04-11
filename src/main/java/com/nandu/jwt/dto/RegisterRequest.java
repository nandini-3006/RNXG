package com.nandu.jwt.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String role; // Must be "USER", "ADMIN" or "ROLE_USER" etc.
}
