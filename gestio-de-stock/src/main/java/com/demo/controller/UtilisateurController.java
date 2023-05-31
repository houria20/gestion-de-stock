package com.demo.controller;

import com.demo.controller.api.UtilisateurApi;
import com.demo.dto.ChangerMotDePasseUtilisateurDto;
import com.demo.dto.UtilisateurDto;
import com.demo.service.UtilisateurService;
import jakarta.inject.Inject;

import java.util.List;

public class UtilisateurController implements UtilisateurApi {
    @Inject
    UtilisateurService utilisateurService;

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto) {
        return utilisateurService.changerMotDePasse(dto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurService.findByEmail(email);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
