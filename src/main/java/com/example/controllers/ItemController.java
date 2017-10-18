package com.example.controllers;

import com.example.models.Item;
import com.example.models.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {

    ItemRepository repository;

    @Autowired
    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getItems() {
        return repository.findAll();
    }

}
