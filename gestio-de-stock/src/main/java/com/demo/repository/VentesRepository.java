package com.demo.repository;

import com.demo.model.Ventes;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

public class VentesRepository implements PanacheRepository<Ventes> {

    public Optional<Ventes> findVentesByCode(String code) {
        return find("code", code).firstResultOptional();
    }

    public Ventes save(Ventes vente) {
        return getEntityManager().merge(vente);
    }
}
