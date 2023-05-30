package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.LigneCommandeClient;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class LigneCommandeClientRepository implements PanacheRepository<LigneCommandeClient> {


  List<LigneCommandeClient> findAllByCommandeClientId(Integer id){
    return list("commandeClient.id", id);
  }

  List<LigneCommandeClient> findAllByArticleId(Integer id){
    return list("article.id", id);
  }
}
