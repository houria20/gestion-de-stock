package com.demo.service;


import com.demo.dto.ArticleDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public interface ArticleService {
    void save(ArticleDto dto);
    void update(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();
    void delete(Integer id);
}
