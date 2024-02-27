package com.ssafy.restapi.service;

import com.ssafy.restapi.domain.Item;
import com.ssafy.restapi.dto.ItemDto;
import com.ssafy.restapi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(ItemDto itemDto) {
        Item item = Item.builder()
                .name(itemDto.getName())
                .count(itemDto.getCount())
                .build();

        itemRepository.save(item);
    }

    public ItemDto findItemById(Long id) {
        Item item = itemRepository.findById(id);

        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .count(item.getCount())
                .build();
    }

    public List<ItemDto> findAllItem() {
        return itemRepository.findAll()
                .stream()
                .map(item -> ItemDto.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .count(item.getCount())
                        .build())
                .toList();
    }

    public void updateItemById(Long id, ItemDto itemDto) {
        Item findItem = itemRepository.findById(id);
        findItem.updateItem(itemDto.getName(), itemDto.getCount());

        itemRepository.updateById(id, findItem);
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
}
