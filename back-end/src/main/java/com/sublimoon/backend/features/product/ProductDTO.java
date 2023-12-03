package com.sublimoon.backend.features.product;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductDTO(
    UUID id,

    @NotBlank
    @Size(
        min = 2,
        max = 50,
        message = "O nome do produto deve conter entre 2 e 50 caracteres."
    )
    String nome,

    Category categoria,

    Color color,

    @NotBlank
    @Size(
        min = 2,
        max = 200,
        message = "A descrição deve conter entre 2 e 200 caracteres."
    )
    String descricao,

    @NotBlank
    String imagem,

    @NotNull
    float preco,

    @NotNull
    float quantidade,

    @NotNull
    float mediaAvaliacao,

    @NotBlank
    @Size(
        min = 1,
        max = 20,
        message = "O tamanho deve conter entre 2 e 20 caracteres."
    )
    String tamanho
) {
    public ProductModel convertToModel() {
        return new ProductModel(
            id, 
            nome, 
            categoria, 
            color, 
            descricao, 
            imagem, 
            preco, 
            quantidade, 
            mediaAvaliacao, 
            tamanho
        );
    }
}
