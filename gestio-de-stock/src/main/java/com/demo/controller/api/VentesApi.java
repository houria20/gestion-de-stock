package com.demo.controller.api;

import com.demo.dto.VentesDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT + "/ventes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface VentesApi {
    @POST
    VentesDto save(VentesDto dto);

    @GET
    @Path("/{id}")
    VentesDto findById(@PathParam("id") Integer id);

    @GET
    @Path("/filter/{code}")
    VentesDto findByCode(@PathParam("code") String code);

    @GET
    @Path("/all")
    List<VentesDto> findAll();

    @DELETE
    @Path("/{id}")
    void delete(Integer id);
}
