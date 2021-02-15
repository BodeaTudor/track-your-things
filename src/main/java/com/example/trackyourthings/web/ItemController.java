package com.example.trackyourthings.web;

import com.example.trackyourthings.domain.Item;
import com.example.trackyourthings.service.ItemService;
import com.example.trackyourthings.transfer.CreateItemRequest;
import com.example.trackyourthings.transfer.UpdateItemTypeFieldRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public ResponseEntity<Page<Item>> getItems(Pageable pageable) {

        Page<Item> items = itemService.getItems(pageable);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Item> updateTypeField(long id, @RequestBody UpdateItemTypeFieldRequest request) {

        Item item = itemService.updateTypeField(id, request);

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteItem(long id) {

        itemService.deleteItem(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}