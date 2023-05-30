package com.demo.service;

import com.demo.dto.ChangerMotDePasseUtilisateurDto;
import com.demo.dto.UtilisateurDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public interface UtilisateurService {

  void save(UtilisateurDto dto);

  UtilisateurDto findById(Integer id);

  List<UtilisateurDto> findAll();

  void delete(Integer id);

  UtilisateurDto findByEmail(String email);

  void changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);


}
