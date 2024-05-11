package com.sublimoon.backend.features.carousel_item;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carousel")
@CrossOrigin(origins = "*")
public class CarouselItemController {
    
    private final CarouselItemService carouselItemService;

    public CarouselItemController(CarouselItemService carouselItemService) {
        this.carouselItemService = carouselItemService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> post(
        @RequestBody @Validated CarouselItemDTO carouselItemDTO) {

        try {
            carouselItemService.createProduct(carouselItemDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                exception.getMessage()
            );
        }
    };

    @GetMapping
    public ResponseEntity<List<CarouselItemDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
            carouselItemService.getAll()
        );
    }
}
