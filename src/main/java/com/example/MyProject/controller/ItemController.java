package com.example.MyProject.controller;

import com.example.MyProject.dto.ItemDTO;
import com.example.MyProject.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    public String saveItem(@Valid @RequestBody ItemDTO itemDTO) {
        return itemService.saveItem(itemDTO);
    }
}
