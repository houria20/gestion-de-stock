package com.demo.service.impl;

import com.demo.dto.ArticleDto;
import com.demo.dto.CategoryDto;
import com.demo.dto.ClientDto;
import com.demo.exception.EntityNotFoundException;
import com.demo.exception.ErrorCodes;
import com.demo.exception.InvalidEntityException;
import com.demo.model.Article;
import com.demo.model.Client;
import com.demo.repository.CategoryRepository;
import com.demo.repository.ClientRepository;
import com.demo.service.ClientService;
import com.demo.validator.CategoryValidator;
import com.demo.validator.ClientValidator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Inject
    ClientRepository clientRepository;
    @Override
    @Transactional
    public void save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("La client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        clientRepository.save(ClientDto.toEntity(dto));
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }
        Optional<Client> client = Optional.ofNullable(clientRepository.findById(id.longValue()));
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun client avec l'ID = " + id + " n' été trouvé dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return;
        }
        clientRepository.delete(clientRepository.findById(Long.valueOf(id)));
    }
}
