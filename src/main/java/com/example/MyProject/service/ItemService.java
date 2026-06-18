package com.example.MyProject.service;

import com.example.MyProject.dto.ItemDTO;
import com.example.MyProject.entity.Item;
import com.example.MyProject.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    // Save Item
    public String saveItem(ItemDTO itemDTO){
        Item item = new Item();

        item.setItemName(itemDTO.getItemName());
        item.setItemPrice(itemDTO.getItemPrice());
        item.setItemQuantity(itemDTO.getItemQuantity());

        itemRepo.save(item);

        return "Item saved successfully !";
    }

    // Update Item
    public String updateItem(ItemDTO itemDTO){
        Item item = itemRepo.findById(itemDTO.getItemId()).
                orElseThrow(() ->
                        new RuntimeException("Item not found !"));

        item.setItemName(itemDTO.getItemName());
        item.setItemPrice(itemDTO.getItemPrice());
        item.setItemQuantity(itemDTO.getItemQuantity());

        itemRepo.save(item);

        return "Item updated successfully !";
    }

    // Delete Item
    public String deleteItem(long itemId){
        itemRepo.deleteById(itemId);
        return "Item deleted successfully !";
    }
}
