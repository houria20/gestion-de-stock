package com.demo.controller;

import com.demo.controller.api.FournisseurApi;
import com.demo.dto.FournisseurDto;
import com.demo.service.FournisseurService;
import jakarta.inject.Inject;

import java.util.List;

public class FournisseurController implements FournisseurApi {
    @Inject
    FournisseurService fournisseurService;

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}
