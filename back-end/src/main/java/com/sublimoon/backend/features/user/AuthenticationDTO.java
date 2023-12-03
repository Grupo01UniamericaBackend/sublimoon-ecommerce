package com.sublimoon.backend.features.user;

import jakarta.validation.constraints.Email;

public record AuthenticationDTO(
    @Email
    String email,
    String password
) {}
