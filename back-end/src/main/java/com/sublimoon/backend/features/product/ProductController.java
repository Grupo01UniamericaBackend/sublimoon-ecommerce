package com.sublimoon.backend.features.product;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
public class ProductController {

    private final ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> post(
        @RequestBody @Validated ProductDTO newProduct
    ) {
        try {
            productService.createProduct(newProduct);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                exception.getMessage()
            );
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> put(
        @RequestBody @Validated ProductDTO updatedProduct, 
        @PathVariable UUID id
    ) {
        try {
            productService.updateProduct(updatedProduct, id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                exception.getMessage()
            );
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        try {
            productService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                exception.getMessage()
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(productService.getById(id));
        } catch(Exception exception) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProductDTO>> getAllByCategoria(
        @PathVariable("categoria") Category category
    ) {
        return ResponseEntity.ok(productService.getAllByCategoria(category));
    }
}
