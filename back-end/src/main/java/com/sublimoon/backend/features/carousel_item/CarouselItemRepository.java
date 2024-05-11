package com.sublimoon.backend.features.carousel_item;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarouselItemRepository 
    extends JpaRepository<CarouselItemModel, UUID>{
    
}
