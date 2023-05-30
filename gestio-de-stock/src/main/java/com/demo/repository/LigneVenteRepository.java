package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.LigneVente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class LigneVenteRepository implements PanacheRepository<LigneVente> {

    List<LigneVente> findAllByArticleId(Integer idArticle) {
        return list("article.id", idArticle);
    }

    List<LigneVente> findAllByVenteId(Integer id) {
        return list("vente.id", id);
    }
}
