package com.sublimoon.backend.features.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductDTO newProduct) {
        if (productRepository.existsByNome(newProduct.nome())) {
            throw new IllegalArgumentException(
                "Este nome de produto já está em uso."
            );
        }
        productRepository.save(newProduct.convertToModel());
    }
}
