package com.demo.service;

import com.demo.dto.ClientDto;
import com.demo.model.Client;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public interface ClientService {

  Client save(ClientDto dto);

  ClientDto findById(Integer id);

  List<ClientDto> findAll();

  void delete(Integer id);

}
