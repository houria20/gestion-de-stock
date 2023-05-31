package com.demo.service.impl;

import com.demo.dto.EntrepriseDto;
import com.demo.exception.EntityNotFoundException;
import com.demo.exception.ErrorCodes;
import com.demo.exception.InvalidEntityException;
import com.demo.model.Entreprise;
import com.demo.repository.EntrepriseRepository;
import com.demo.service.EntrepriseService;
import com.demo.validator.EntrepriseValidator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    @Inject
    EntrepriseRepository entrepriseRepository;

    @Override
    @Transactional
    public Entreprise save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Enterprise is not valid {}", dto);
            throw new InvalidEntityException("L'Enterprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        } else {
            return entrepriseRepository.save(EntrepriseDto.toEntity(dto));
        }
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null) {
            log.error("Entreprise ID is null");
            return null;
        }
        Optional<Entreprise> e = Optional.ofNullable(entrepriseRepository.findById(id.longValue()));
        return Optional.of(EntrepriseDto.fromEntity(e.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune entreprise avec l'ID = " + id + " n' été trouvée dans la BDD",
                        ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (id == null) {
            log.error("Enterprise ID is null");
            return;
        }
        entrepriseRepository.delete(entrepriseRepository.findById(Long.valueOf(id)));
    }
}
