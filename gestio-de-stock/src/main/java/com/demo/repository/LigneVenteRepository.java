package com.demo.repository;

import com.demo.model.LigneVente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class LigneVenteRepository implements PanacheRepository<LigneVente> {

    public List<LigneVente> findAllByArticleId(Integer idArticle) {
        return list("article.id", idArticle);
    }

    public List<LigneVente> findAllByVenteId(Integer id) {
        return list("vente.id", id);
    }

    public LigneVente save(LigneVente ligneVente) {
        return getEntityManager().merge(ligneVente);
    }
}
