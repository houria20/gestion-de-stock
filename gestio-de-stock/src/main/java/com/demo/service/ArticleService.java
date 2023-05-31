package com.demo.service;


import com.demo.dto.ArticleDto;
import com.demo.dto.LigneCommandeClientDto;
import com.demo.dto.LigneCommandeFournisseurDto;
import com.demo.dto.LigneVenteDto;
import com.demo.model.Article;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public interface ArticleService {
    Article save(ArticleDto dto);
    Article update(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();
    void delete(Integer id);
    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);
}
