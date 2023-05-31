package com.demo.controller;

import com.demo.controller.api.ArticleApi;
import com.demo.dto.ArticleDto;
import com.demo.service.ArticleService;
import jakarta.inject.Inject;

import java.util.List;

public class ArticleController implements ArticleApi {
    @Inject
    private ArticleService articleService;

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }
    @Override
    public ArticleDto update(ArticleDto dto) {
        return articleService.update(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
