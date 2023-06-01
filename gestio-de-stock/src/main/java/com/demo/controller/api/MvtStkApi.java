package com.demo.controller.api;

import com.demo.dto.MvtStkDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static com.demo.utils.Constants.APP_ROOT;

@Path(APP_ROOT + "/stock")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface MvtStkApi {
    @GET
    @Path(APP_ROOT + "/stockreel/{idArticle}")
    long stockReelArticle(@PathParam("idArticle") Integer idArticle);

    @GET
    @Path(APP_ROOT + "/filter/article/{idArticle}")
    List<MvtStkDto> mvtStkArticle(@PathParam("idArticle") Integer idArticle);

    @POST
    @Path(APP_ROOT+"/entree")
    MvtStkDto entreeStock(MvtStkDto dto);

    @POST
    @Path(APP_ROOT+"/sortie")
    MvtStkDto sortieStock(MvtStkDto dto);

    @POST
    @Path(APP_ROOT+"correctionpos")
    MvtStkDto correctionStockPos(MvtStkDto dto);

    @POST
    @Path(APP_ROOT+"correctionneg")
    MvtStkDto correctionStockNeg(MvtStkDto dto);
}
