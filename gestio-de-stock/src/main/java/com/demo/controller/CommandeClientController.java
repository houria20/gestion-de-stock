package com.demo.controller;

import com.demo.controller.api.CommandeClientApi;
import com.demo.dto.CommandeClientDto;
import com.demo.dto.LigneCommandeClientDto;
import com.demo.model.EtatCommande;
import com.demo.service.CommandeClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;

public class CommandeClientController implements CommandeClientApi {
    @Inject
    CommandeClientService commandeClientService;

    @Override
    public Response save(CommandeClientDto dto) {
        return Response.ok(commandeClientService.save(dto)).build();
    }

    @Override
    public CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
        return commandeClientService.updateEtatCommande(idCommande, etatCommande);
    }

    @Override
    public CommandeClientDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
        return commandeClientService.updateQuantiteCommande(idCommande, idLigneCommande, quantite);
    }

    @Override
    public CommandeClientDto updateClient(Integer idCommande, Integer idClient) {
        return commandeClientService.updateClient(idCommande, idClient);
    }

    @Override
    public CommandeClientDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle) {
        return commandeClientService.updateArticle(idCommande, idLigneCommande, newIdArticle);
    }

    @Override
    public CommandeClientDto deleteArticle(Integer idCommande, Integer idLigneCommande) {
        return commandeClientService.deleteArticle(idCommande, idLigneCommande);
    }

    @Override
    public Response findById(Integer id) {
        return Response.ok(commandeClientService.findById(id)).build();
    }

    @Override
    public Response findByCode(String code) {
        return Response.ok(commandeClientService.findByCode(code)).build();
    }

    @Override
    public Response findAll() {
        return Response.ok(commandeClientService.findAll()).build();
    }

    @Override
    public List<LigneCommandeClientDto> findAllLignesCommandesClientByCommandeClientId(Integer idCommande) {
        return null;
    }

    @Override
    public Response delete(Integer id) {
        commandeClientService.delete(id);
        return Response.ok().build();
    }
}
