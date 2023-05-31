package com.demo.controller.api;

import com.demo.dto.ChangerMotDePasseUtilisateurDto;
import com.demo.dto.UtilisateurDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT + "/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UtilisateurApi {
    @POST
    UtilisateurDto save(UtilisateurDto dto);

    @POST
    UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);
    @GET
    @Path("/{id}")
    UtilisateurDto findById(@PathParam("id") Integer id);

    @GET
    @Path("/filter/{email}")
    UtilisateurDto findByEmail(@PathParam("email") String email);

    @GET
    @Path("/all")
    List<UtilisateurDto> findAll();
    @DELETE
    @Path("/{id}")
    void delete(@PathParam("idUtilisateur") Integer id);
}
