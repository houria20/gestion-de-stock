package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.Category;
import com.demo.model.Fournisseur;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class FournisseurRepository implements PanacheRepository<Fournisseur> {
    public void save(Fournisseur fournisseur) {
        getEntityManager().merge(fournisseur);
    }
}
