package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.CommandeClient;
import com.demo.model.CommandeFournisseur;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
@ApplicationScoped
public class CommandeFournisseurRepository implements PanacheRepository<CommandeFournisseur> {
    public CommandeFournisseur save(CommandeFournisseur commandeFournisseur) {
        return getEntityManager().merge(commandeFournisseur);
    }

    public Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code) {
        return find("code", code).firstResultOptional();
    }

    public List<CommandeFournisseur> findAllByFournisseurId(Integer id) {
        return list("fournisseur.id", id);
    }
}
