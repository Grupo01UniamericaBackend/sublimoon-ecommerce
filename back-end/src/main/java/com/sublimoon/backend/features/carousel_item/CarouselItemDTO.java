package com.sublimoon.backend.features.carousel_item;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record CarouselItemDTO(
    UUID id,
    @NotBlank String image,
    @NotBlank String link
) {
    public CarouselItemModel convertToModel() {
        return new CarouselItemModel(id, image, link);
    }
}
