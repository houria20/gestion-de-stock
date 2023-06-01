package com.demo.controller.api;

import com.demo.dto.FournisseurDto;
import com.demo.dto.FournisseurDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT+"/fournisseurs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface FournisseurApi {
    @POST
    FournisseurDto save(FournisseurDto dto);

    @GET
    @Path("/{id}")
    FournisseurDto findById(@PathParam("id") Integer id);

    @GET
    @Path("/all")
    List<FournisseurDto> findAll();

    @DELETE
    @Path("/{id}")
    void delete(Integer id);
}
