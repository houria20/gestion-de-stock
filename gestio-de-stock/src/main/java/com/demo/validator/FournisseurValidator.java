package com.demo.validator;

import com.demo.dto.FournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le nom du fournisseur");
            errors.add("Veuillez renseigner le prenom du fournisseur");
            errors.add("Veuillez renseigner le Mail du fournisseur");
            errors.add("Veuillez renseigner le numero de telephone du fournisseur");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (dto.getNom() == null || dto.getNom().equals("")) {
            errors.add("Veuillez renseigner le nom du fournisseur");
        }
        if (dto.getPrenom() == null || dto.getPrenom().equals("")) {
            errors.add("Veuillez renseigner le prenom du fournisseur");
        }
        if (dto.getMail() == null || dto.getMail().equals("")) {
            errors.add("Veuillez renseigner le Mail du fournisseur");
        }
        if (dto.getNumTel() == null || dto.getNumTel().equals("")) {
            errors.add("Veuillez renseigner le numero de telephone du fournisseur");
        }
        errors.addAll(AdresseValidator.validate(dto.getAdresse()));
        return errors;
    }

}
