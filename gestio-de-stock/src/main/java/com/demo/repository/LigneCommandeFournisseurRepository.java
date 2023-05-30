package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.LigneCommandeFournisseur;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class LigneCommandeFournisseurRepository implements PanacheRepository<LigneCommandeFournisseur> {

  List<LigneCommandeFournisseur> findAllByCommandeFournisseurId(Integer idCommande){
    return list("commandeFournisseur.id", idCommande);
  }

  List<LigneCommandeFournisseur> findAllByArticleId(Integer idArticle){
    return list("article.id", idArticle);
  }
}
