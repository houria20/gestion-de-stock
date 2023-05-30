package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.Category;
import com.demo.model.Entreprise;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class EntrepriseRepository implements PanacheRepository<Entreprise> {
    public void save(Entreprise entreprise) {
        getEntityManager().merge(entreprise);
    }
}
