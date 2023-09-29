package com.pos.api.controller;

import com.pos.api.model.Item;
import com.pos.api.repository.ItemRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/items")
public class ItemController extends BaseRestController<Item, ItemRepository> {
    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    protected ItemRepository getRepository() {
        return this.repository;
    }
}
