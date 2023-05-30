package com.demo.controller.api;


import com.demo.dto.ArticleDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT+"/articles")
public interface ArticleApi {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    void save(ArticleDto dto);
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ArticleDto dto);
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    ArticleDto findById(@PathParam("id") Integer id);
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/filter/{code}")
    ArticleDto findByCodeArticle(@PathParam("code") String codeArticle);
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    List<ArticleDto> findAll();
    @DELETE
    @Path("/{id}")
    void delete(Integer id);
}
