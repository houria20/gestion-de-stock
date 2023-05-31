package com.demo.controller;

import com.demo.controller.api.CategoryApi;
import com.demo.dto.CategoryDto;
import com.demo.service.CategoryService;
import jakarta.inject.Inject;

import java.util.List;

public class CategoryController implements CategoryApi {
    @Inject
    private CategoryService categoryService;

    @Override
    public void save(CategoryDto dto) {
        categoryService.save(dto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findByCode(String code) {
        return categoryService.findByCode(code);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
