package com.sublimoon.backend.features.item;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ItemDTO(

    UUID id,

    @NotBlank
    @Size(
        min = 2,
        max = 50,
        message = "O nome do item deve conter entre 2 e 50 caracteres."
    )
    String name, 

    @NotBlank
    @Size(
        min = 1,
        max = 50,
        message = "O preço deve conter entre 1 e 50 caracteres"
    )
    String price, 

    @NotBlank
    @Size(
        min = 2,
        max = 256,
        message = "A descrição teve conter no mínimo 2 caracteres."
    )
    String description,

    String operationActor
    ) {
    
    public ItemEntity convertToEntity() {
        return new ItemEntity(
            id, 
            name, 
            price, 
            description,
            operationActor
        );
    }
}
