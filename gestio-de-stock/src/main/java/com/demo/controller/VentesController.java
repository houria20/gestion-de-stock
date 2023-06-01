package com.demo.controller;

import com.demo.controller.api.VentesApi;
import com.demo.dto.VentesDto;
import com.demo.service.VentesService;
import jakarta.inject.Inject;

import java.util.List;

public class VentesController implements VentesApi {
    @Inject
    VentesService ventesService;
    @Override
    public VentesDto save(VentesDto dto) {
        return ventesService.save(dto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return ventesService.findById(id);
    }

    @Override
    public VentesDto findByCode(String code) {
        return ventesService.findByCode(code);
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesService.findAll();
    }

    @Override
    public void delete(Integer id) {
        ventesService.delete(id);
    }
}
