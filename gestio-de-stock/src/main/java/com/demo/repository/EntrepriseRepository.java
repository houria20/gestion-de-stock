package com.demo.repository;

import com.demo.model.Entreprise;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EntrepriseRepository implements PanacheRepository<Entreprise> {
    public Entreprise save(Entreprise entreprise) {
        return getEntityManager().merge(entreprise);
    }
}
