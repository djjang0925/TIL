package com.ssafy.restapi.controller;

import com.ssafy.restapi.dto.ItemDto;
import com.ssafy.restapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ItemController {
    private final ItemService itemService;

    @PostMapping("items")
    public void save(@RequestBody ItemDto itemDto) {
        itemService.saveItem(itemDto);
    }

    @GetMapping("items/{id}")
    public ItemDto findItemById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

    @GetMapping("items")
    public List<ItemDto> findAllItem() {
        return itemService.findAllItem();
    }

    @PatchMapping("items/{id}")
    public void updateItemById(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        itemService.updateItemById(id, itemDto);
    }

    @DeleteMapping("items/{id}")
    public void deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
    }
}
