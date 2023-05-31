package com.demo.controller.api;


import com.demo.dto.ClientDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT + "/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ClientApi {
    @POST
    void save(ClientDto dto);

    @GET
    @Path("/{id}")
    ClientDto findById(@PathParam("id") Integer id);

    @GET
    @Path("/all")
    List<ClientDto> findAll();

    @DELETE
    @Path("/{id}")
    void delete(Integer id);
}
