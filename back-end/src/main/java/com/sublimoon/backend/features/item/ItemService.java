package com.sublimoon.backend.features.item;

import org.springframework.stereotype.Service;

@Service
public class ItemService {
    
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(ItemDTO itemDTO) {
        this.itemRepository.save(itemDTO.convertToEntity());
    }
}
