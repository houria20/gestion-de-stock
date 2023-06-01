package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.LigneCommandeClient;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public class LigneCommandeClientRepository implements PanacheRepository<LigneCommandeClient> {

  public LigneCommandeClient save(LigneCommandeClient lg) {
    return getEntityManager().merge(lg);
  }
  public List<LigneCommandeClient> findAllByCommandeClientId(Integer id){
    return list("commandeClient.id", id);
  }

  public List<LigneCommandeClient> findAllByArticleId(Integer id){
    return list("article.id", id);
  }
}
