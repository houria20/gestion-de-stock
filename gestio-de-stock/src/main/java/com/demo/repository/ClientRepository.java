package com.demo.repository;

import com.demo.model.Article;
import com.demo.model.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class ClientRepository implements PanacheRepository<Client> {
    public void save(Client client) {
        getEntityManager().merge(client);
    }
}
