package com.sublimoon.backend.features.item;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/item")
public class ItemController {
    
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    private ResponseEntity<String> get() {
        return ResponseEntity.ok("Funcionou!");
    }

    @PostMapping
    private ResponseEntity<String> createItem(
        @RequestBody @Validated ItemDTO itemDTO
        ) {
        try {
            itemService.createItem(itemDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                exception.getMessage()
            );
        }
    }
}
