package com.demo.controller.api;

import com.demo.dto.EntrepriseDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT + "/entreprises")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface EntrepriseApi {
    @POST
    EntrepriseDto save(EntrepriseDto dto);

    @GET
    @Path("/{id}")
    EntrepriseDto findById(@PathParam("id") Integer id);

    @GET
    @Path("/all")
    List<EntrepriseDto> findAll();

    @DELETE
    @Path("/{id}")
    void delete(Integer id);
}
