package com.pos.api.controller;

import com.pos.api.model.Category;
import com.pos.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categories")
public class CategoryController extends BaseRestController<Category, CategoryRepository>  {

    @Autowired
    private final CategoryRepository repository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    @Override
    protected CategoryRepository getRepository() {
        return this.repository;
    }
}
