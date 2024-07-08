package com.sparta.hangehaemarket.controller;

import com.sparta.hangehaemarket.dto.ItemDto;
import com.sparta.hangehaemarket.model.Item;
import com.sparta.hangehaemarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> crateItem(@RequestBody ItemDto itemDto) {
        Item item = itemService.createItem(itemDto);
        return ResponseEntity.status(201).body(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        Item item = itemService.getItem(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        List<Item> items = itemService.getItems();
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        Item item = itemService.updateItem(id, itemDto);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok().build();
    }

}
