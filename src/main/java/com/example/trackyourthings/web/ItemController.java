package com.example.trackyourthings.web;

import com.example.trackyourthings.domain.Item;
import com.example.trackyourthings.service.ItemService;
import com.example.trackyourthings.transfer.CreateItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody @Valid CreateItemRequest request) {

        Item createdItem = itemService.createItem(request);

        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }
}