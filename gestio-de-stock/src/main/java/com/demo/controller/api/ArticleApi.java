package com.demo.controller.api;


import com.demo.dto.ArticleDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT + "/articles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ArticleApi {
    @POST
    ArticleDto save(ArticleDto dto);

    @PUT
    ArticleDto update(ArticleDto dto);

    @GET
    @Path("/{id}")
    ArticleDto findById(@PathParam("id") Integer id);

    @GET
    @Path("/filter/{code}")
    ArticleDto findByCodeArticle(@PathParam("code") String codeArticle);

    @GET
    @Path("/all")
    List<ArticleDto> findAll();

    @DELETE
    @Path("/{id}")
    void delete(Integer id);
}
