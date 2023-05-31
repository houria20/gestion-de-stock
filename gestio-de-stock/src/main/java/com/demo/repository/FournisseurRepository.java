package com.demo.repository;

import com.demo.model.Fournisseur;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class FournisseurRepository implements PanacheRepository<Fournisseur> {
    public Fournisseur save(Fournisseur fournisseur) {
        return getEntityManager().merge(fournisseur);
    }
}
