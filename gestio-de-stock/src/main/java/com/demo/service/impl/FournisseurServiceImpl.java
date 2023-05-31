package com.demo.service.impl;

import com.demo.dto.FournisseurDto;
import com.demo.exception.EntityNotFoundException;
import com.demo.exception.ErrorCodes;
import com.demo.exception.InvalidEntityException;
import com.demo.model.Fournisseur;
import com.demo.repository.FournisseurRepository;
import com.demo.service.FournisseurService;
import com.demo.validator.FournisseurValidator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    @Inject
    FournisseurRepository fournisseurRepository;

    @Override
    @Transactional
    public Fournisseur save(FournisseurDto dto) {
        List<String> errors = FournisseurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Fournisseur is not valid {}", dto);
            throw new InvalidEntityException("Le fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
        } else {
            return fournisseurRepository.save(FournisseurDto.toEntity(dto));
        }
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if (id == null) {
            log.error("Fournisseur ID is null");
            return null;
        }
        Optional<Fournisseur> f = Optional.ofNullable(fournisseurRepository.findById(id.longValue()));
        return Optional.of(FournisseurDto.fromEntity(f.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun fournisseur avec l'ID = " + id + " n' été trouvé dans la BDD",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (id == null) {
            log.error("Fournisseur ID is null");
            return;
        }
        fournisseurRepository.delete(fournisseurRepository.findById(Long.valueOf(id)));
    }
}
