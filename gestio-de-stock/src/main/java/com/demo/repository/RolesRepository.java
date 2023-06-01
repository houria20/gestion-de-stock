package com.demo.repository;

import com.demo.model.Roles;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RolesRepository implements PanacheRepository<Roles> {

}
