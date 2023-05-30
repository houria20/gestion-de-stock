package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.CommandeClient;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;
import java.util.Optional;

public class CommandeClientRepository implements PanacheRepository<CommandeClient> {
    public Optional<CommandeClient> findCommandeClientByCode(String code) {
        return find("code", code).firstResultOptional();
    }

    public List<CommandeClient> findAllByClientId(Integer id) {
        return list("client.id", id);
    }
}
