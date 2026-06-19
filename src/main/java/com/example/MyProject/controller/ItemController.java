package com.example.MyProject.controller;

import com.example.MyProject.dto.ItemDTO;
import com.example.MyProject.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@Valid @RequestBody ItemDTO itemDTO) {
        return itemService.saveItem(itemDTO);
    }

    @PutMapping("/update")
    public String updateItem(@Valid @RequestBody ItemDTO itemDTO) {
        return itemService.updateItem(itemDTO);
    }

    @DeleteMapping("/{itemId}")
    public String deleteItem(@PathVariable long itemId){
        return itemService.deleteItem(itemId);
    }

    @GetMapping("/getAllItems")
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{itemId}")
    public ItemDTO searchItemById(@PathVariable long itemId) {
        return itemService.getItemById(itemId);
    }
}
