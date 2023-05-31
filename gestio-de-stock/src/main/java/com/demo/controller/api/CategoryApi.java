package com.demo.controller.api;


import com.demo.dto.CategoryDto;
import com.demo.dto.CategoryDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT + "/categories")
public interface CategoryApi {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    void save(CategoryDto dto);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    CategoryDto findById(@PathParam("id") Integer id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/filter/{code}")
    CategoryDto findByCode(@PathParam("code") String code);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    List<CategoryDto> findAll();

    @DELETE
    @Path("/{id}")
    void delete(Integer id);
}
