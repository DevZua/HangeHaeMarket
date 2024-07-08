package com.sparta.hangehaemarket.service;

import com.sparta.hangehaemarket.dto.ItemDto;
import com.sparta.hangehaemarket.model.Item;
import com.sparta.hangehaemarket.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item createItem(ItemDto itemDto) {
        Item item = new Item();
        item.setTitle(itemDto.getTitle());
        item.setContent(itemDto.getContent());
        item.setPrice(itemDto.getPrice());
        item.setUsername(itemDto.getUsername());
        return itemRepository.save(item);
    }

    public Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item updateItem(Long id, ItemDto itemDto) {
        Item item = getItem(id);
        item.setTitle(itemDto.getTitle());
        item.setContent(itemDto.getContent());
        item.setPrice(itemDto.getPrice());
        item.setUsername(itemDto.getUsername());
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
