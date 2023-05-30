package com.demo.service;

import com.demo.dto.CategoryDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface CategoryService {

  void save(CategoryDto dto);

  CategoryDto findById(Integer id);

  CategoryDto findByCode(String code);

  List<CategoryDto> findAll();

  void delete(Integer id);

}
