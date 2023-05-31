package com.demo.service;

import com.demo.dto.FournisseurDto;
import com.demo.model.Fournisseur;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public interface FournisseurService {

  Fournisseur save(FournisseurDto dto);

  FournisseurDto findById(Integer id);

  List<FournisseurDto> findAll();

  void delete(Integer id);

}
