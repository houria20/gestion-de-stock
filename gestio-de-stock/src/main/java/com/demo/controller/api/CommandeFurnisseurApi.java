package com.demo.controller.api;

import com.demo.dto.CommandeFournisseurDto;
import com.demo.dto.LigneCommandeFournisseurDto;
import com.demo.model.EtatCommande;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;
import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT + "/commandesfournisseur")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CommandeFurnisseurApi {
    @POST
    CommandeFournisseurDto save(CommandeFournisseurDto dto);
    @PATCH
    @Path("/update/etat/{idCommande}/{etatCommande}")
    CommandeFournisseurDto updateEtatCommande(@PathParam("idCommande") Integer idCommande,@PathParam("etatCommande") EtatCommande etatCommande);
    @PATCH
    @Path("/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
    CommandeFournisseurDto updateQuantiteCommande(@PathParam("idCommande") Integer idCommande,@PathParam("idLigneCommande") Integer idLigneCommande,@PathParam("quantite") BigDecimal quantite);
    @PATCH
    @Path("/update/client/{idCommande}/{idFournisseur}")
    CommandeFournisseurDto updateFournisseur(@PathParam("idCommande") Integer idCommande,@PathParam("idFournisseur") Integer idFournisseur);
    @PATCH
    @Path("/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    CommandeFournisseurDto updateArticle(@PathParam("idCommande") Integer idCommande,@PathParam("idLigneCommande") Integer idLigneCommande,@PathParam("idArticle") Integer idArticle);
    @DELETE
    @Path("/delete/article/{idCommande}/{idLigneCommande}")
    CommandeFournisseurDto deleteArticle(@PathParam("idCommande") Integer idCommande,@PathParam("idLigneCommande") Integer idLigneCommande);

    @GET
    @Path("/{id}")
    CommandeFournisseurDto findById(@PathParam("id")Integer id);
    @GET
    @Path("/{code}")
    CommandeFournisseurDto findByCode(@PathParam("code")String code);
    @GET
    @Path("/all")
    List<CommandeFournisseurDto> findAll();

    List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(Integer idCommande);
    @DELETE
    @Path("/{id}")
    void delete(Integer id);
}
