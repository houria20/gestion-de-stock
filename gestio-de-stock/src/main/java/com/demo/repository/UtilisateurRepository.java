package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.Utilisateur;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

public class UtilisateurRepository implements PanacheRepository<Utilisateur> {

    public Optional<Utilisateur> findByCodeArticle(String email) {
        return find("email", email).firstResultOptional();
    }
}
