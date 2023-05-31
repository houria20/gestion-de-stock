package com.demo.repository;

import com.demo.model.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

public class CategoryRepository implements PanacheRepository<Category> {
    public Category save(Category category) {
        return  getEntityManager().merge(category);
    }

    public Optional<Category> findCategoryByCode(String code) {
        return find("code", code).firstResultOptional();
    }

}
