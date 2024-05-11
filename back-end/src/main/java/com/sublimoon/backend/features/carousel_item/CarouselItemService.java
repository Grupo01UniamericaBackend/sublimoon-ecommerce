package com.sublimoon.backend.features.carousel_item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarouselItemService {

    private final CarouselItemRepository repository;
    
    public CarouselItemService(CarouselItemRepository repository) {
        this.repository = repository;
    }

    public void createProduct(CarouselItemDTO carouselItemDTO) {
        this.repository.save(carouselItemDTO.convertToModel());
    }

    public List<CarouselItemDTO> getAll() {
        List<CarouselItemModel> carouselItemModels = repository.findAll();
        List<CarouselItemDTO> carouselItemDTOs = new ArrayList<>();

        for(CarouselItemModel carouselItem : carouselItemModels) {
            carouselItemDTOs.add(carouselItem.convertToDTO());
        }

        return carouselItemDTOs;
    }
}
