package com.sublimoon.backend.features.user;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterDTO(
    @Email
    String email,

    @NotBlank
    @Size(
        min = 8,
        max = 20,
        message = "A senha deve conter entre 8 e 20 caracteres."
    )
    String password, 
    
    @NotBlank
    @Size(
        min = 2,
        max = 50,
        message = "O nome deve conter entre 2 e 50 caracteres."
    )
    String name
) {

    public UserModel convertToModel() {
        return new UserModel(
            null,
            email,
            new BCryptPasswordEncoder().encode(password),
            name,
            false
        );
    }
}
