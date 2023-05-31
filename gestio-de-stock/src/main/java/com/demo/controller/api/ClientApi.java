package com.demo.controller.api;


import com.demo.dto.ClientDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT + "/clients")
public interface ClientApi {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    void save(ClientDto dto);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    ClientDto findById(@PathParam("id") Integer id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    List<ClientDto> findAll();

    @DELETE
    @Path("/{id}")
    void delete(Integer id);
}
