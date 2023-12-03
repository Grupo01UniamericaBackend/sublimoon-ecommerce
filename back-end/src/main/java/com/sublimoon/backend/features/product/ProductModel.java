package com.sublimoon.backend.features.product;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_products")
public class ProductModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private Category categoria;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private Color cor;

    @Column(length = 200, nullable = false)
    private String descricao;

    private String imagem;

    @Column(nullable = false)
    private float preco;

    @Column(nullable = false)
    private float quantidade;

    @Column(nullable = false)
    private float mediaAvaliacao;

    @Column(length = 20, nullable = false)
    private String tamanho;

    public ProductDTO convertToDTO() {
        return new ProductDTO(
            id, 
            nome, 
            categoria, 
            cor, 
            descricao, 
            imagem, 
            preco, 
            quantidade, 
            mediaAvaliacao, 
            tamanho
        );
    }
}
