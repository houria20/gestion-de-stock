package com.demo.controller;

import com.demo.controller.api.CategoryApi;
import com.demo.controller.api.ClientApi;
import com.demo.dto.ClientDto;
import com.demo.service.CategoryService;
import com.demo.service.ClientService;
import jakarta.inject.Inject;

import java.util.List;

public class ClientController implements ClientApi {
    @Inject
    private ClientService clientService;

    @Override
    public void save(ClientDto dto) {
        clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
