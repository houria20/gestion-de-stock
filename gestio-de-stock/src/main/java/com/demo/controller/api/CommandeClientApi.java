package com.demo.controller.api;

import com.demo.dto.CommandeClientDto;
import com.demo.dto.LigneCommandeClientDto;
import com.demo.model.EtatCommande;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT + "/commandesclients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CommandeClientApi {
    @POST
    Response save(CommandeClientDto dto);

    @PATCH
    @Path("/update/etat/{idCommande}/{etatCommande}")
    CommandeClientDto updateEtatCommande(@PathParam("idCommande") Integer idCommande, @PathParam("etatCommande") EtatCommande etatCommande);

    @PATCH
    @Path("/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
    CommandeClientDto updateQuantiteCommande(@PathParam("idCommande") Integer idCommande, @PathParam("idLigneCommande") Integer idLigneCommande, @PathParam("quantite") BigDecimal quantite);

    @PATCH
    @Path("/update/client/{idCommande}/{idClient}")
    CommandeClientDto updateClient(@PathParam("idCommande") Integer idCommande, @PathParam("idClient") Integer idClient);

    @PATCH
    @Path("/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    CommandeClientDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle);

    @DELETE
    @Path("/delete/article/{idCommande}/{idLigneCommande}")
    CommandeClientDto deleteArticle(Integer idCommande, Integer idLigneCommande);

    @GET
    @Path("/{id}")
    Response findById(@PathParam("id") Integer id);

    @GET
    @Path("/filter/{code}")
    Response findByCode(@PathParam("code") String code);

    @GET
    @Path("/all")
    Response findAll();

    @GET
    @Path("/lignesCommande/{idCommande}")
    List<LigneCommandeClientDto> findAllLignesCommandesClientByCommandeClientId(Integer idCommande);

    @DELETE
    @Path("/{id}")
    Response delete(Integer id);
}
