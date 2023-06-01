package com.demo.controller;

import com.demo.controller.api.EntrepriseApi;
import com.demo.dto.EntrepriseDto;
import com.demo.service.ArticleService;
import com.demo.service.EntrepriseService;
import jakarta.inject.Inject;

import java.util.List;

public class EntrepriseController implements EntrepriseApi {
    @Inject
    private EntrepriseService entrepriseService;
    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}
