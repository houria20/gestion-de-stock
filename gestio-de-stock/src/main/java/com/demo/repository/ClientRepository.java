package com.demo.repository;

import com.demo.model.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class ClientRepository implements PanacheRepository<Client> {
    public Client save(Client client) {
        return  getEntityManager().merge(client);
    }
}
