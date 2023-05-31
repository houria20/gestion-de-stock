package com.demo.repository;

import com.demo.model.Utilisateur;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

public class UtilisateurRepository implements PanacheRepository<Utilisateur> {
    public Utilisateur save(Utilisateur user) {
        return getEntityManager().merge(user);
    }

    public Optional<Utilisateur> findUtilisateurByEmail(String email) {
        return find("email", email).firstResultOptional();
    }
}
