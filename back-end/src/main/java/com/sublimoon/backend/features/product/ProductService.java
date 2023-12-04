package com.sublimoon.backend.features.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductDTO newProduct) {
        if (productRepository.existsByNome(newProduct.nome())) {
            throw new IllegalArgumentException(
                "Este nome de produto já existe."
            );
        }
        productRepository.save(newProduct.convertToModel());
    }

    public void updateProduct(ProductDTO updatedProduct, UUID id) {
        Assert.isTrue(
            productRepository.existsById(id), 
            "Produto não encontrado."
        );

        // Optional<ProductModel> dbProduct = productRepository.findByNome(updatedProduct.nome());
        // if (dbProduct != null && dbProduct.get().getId() != id) {
        //    throw new IllegalArgumentException(
        //         "Este nome de produto já existe."
        //     );
        // }
        
        ProductModel productModel = updatedProduct.convertToModel();
        productModel.setId(id);

        productRepository.save(productModel);
    }

    public void delete(UUID id) {
        Assert.isTrue(
            productRepository.existsById(id), 
            "Produto não encontrado."
        );

        productRepository.deleteById(id);
    }

    public ProductDTO getById(UUID id) {
        Optional<ProductModel> product = productRepository.findById(id);

        Assert.isTrue(product.isPresent(), "Produto não encontrado.");

        return product.get().convertToDTO();
    }

    public List<ProductDTO> getAll() {
        List<ProductDTO> productsDTOs = new ArrayList<>();
        List<ProductModel> products = productRepository.findAll();

        for(ProductModel product : products) {
            productsDTOs.add(product.convertToDTO());
        }

        return productsDTOs;
    }

    public List<ProductDTO> getAllByCategoria(Category category) {
        List<ProductDTO> productDTOs = new ArrayList<>();
        List<ProductModel> products = productRepository.findByCategoria(category);

        for(ProductModel product : products) {
            productDTOs.add(product.convertToDTO());
        }

        return productDTOs;
    }
}
