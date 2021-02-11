package com.example.trackyourthings.service;

import com.example.trackyourthings.domain.Item;
import com.example.trackyourthings.persistence.ItemRepository;
import com.example.trackyourthings.transfer.CreateItemRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(CreateItemRequest request) {

        LOGGER.info("Creating item: {}", request);

        Item createdItem = new Item();
        BeanUtils.copyProperties(request, createdItem);

        return itemRepository.save(createdItem);
    }

    public Page<Item> getItems(Pageable pageable) {

        LOGGER.info("Retrieving items...");

        return itemRepository.findAll(pageable);
    }
}
