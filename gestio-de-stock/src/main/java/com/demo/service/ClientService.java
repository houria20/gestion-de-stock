package com.demo.service;

import com.demo.dto.ClientDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public interface ClientService {

  void save(ClientDto dto);

  ClientDto findById(Integer id);

  List<ClientDto> findAll();

  void delete(Integer id);

}
