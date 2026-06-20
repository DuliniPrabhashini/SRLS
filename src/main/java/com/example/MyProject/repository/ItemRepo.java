package com.example.MyProject.repository;

import com.example.MyProject.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Long> {
    List<Item> findByItemNameContainingIgnoreCase(String itemName);
}
