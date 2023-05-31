package com.demo.service;

import com.demo.dto.EntrepriseDto;
import com.demo.model.Entreprise;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface EntrepriseService {

  Entreprise save(EntrepriseDto dto);

  EntrepriseDto findById(Integer id);

  List<EntrepriseDto> findAll();

  void delete(Integer id);

}
