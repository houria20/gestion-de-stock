package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

public class CategoryRepository implements PanacheRepository<Category> {

  public Optional<Category> findCategoryByCode(String code) {
    return find("code", code).firstResultOptional();
  }

}
