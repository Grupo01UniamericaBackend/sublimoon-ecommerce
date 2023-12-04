package com.sublimoon.backend.features.product;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID>{
    public boolean existsByNome(String nome);
    public Optional<ProductModel> findByNome(String nome);
    public List<ProductModel> findByCategoria(Category categoria);
}
