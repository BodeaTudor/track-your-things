package com.example.trackyourthings.service;

import com.example.trackyourthings.domain.Item;
import com.example.trackyourthings.exceptions.ResourceNotFoundException;
import com.example.trackyourthings.persistence.ItemRepository;
import com.example.trackyourthings.transfer.CreateItemRequest;
import com.example.trackyourthings.transfer.UpdateItemTypeFieldRequest;
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

    public Item getItem(long id) {

        LOGGER.info("Retrieving item with id: {}", id);

        return itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product " + id + " not found."));
    }

    public Item updateTypeField(long id, UpdateItemTypeFieldRequest request) {

        LOGGER.info("Updating item's type field. Item id {}, {}", id, request);

        Item item = getItem(id);
        BeanUtils.copyProperties(request, item);

        return itemRepository.save(item);
    }

    public void deleteItem(long id) {

        LOGGER.info("Deleting item with id: {}", id);

        itemRepository.deleteById(id);
    }
}
