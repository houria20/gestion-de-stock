package com.demo.validator;

import com.demo.dto.EntrepriseDto;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le nom de l'entreprise");
            errors.add("Veuillez reseigner la description de l'entreprise");
            errors.add("Veuillez reseigner le code fiscal de l'entreprise");
            errors.add("Veuillez reseigner l'email de l'entreprise");
            errors.add("Veuillez reseigner le numero de telephone de l'entreprise");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (dto.getNom() == null || dto.getNom().equals("")) {
            errors.add("Veuillez renseigner le nom de l'entreprise");
        }
        if (dto.getDescription() == null || dto.getDescription().equals("")) {
            errors.add("Veuillez reseigner la description de l'entreprise");
        }
        if (dto.getCodeFiscal() == null || dto.getCodeFiscal().equals("")) {
            errors.add("Veuillez reseigner le code fiscal de l'entreprise");
        }
        if (dto.getEmail() == null || dto.getEmail().equals("")) {
            errors.add("Veuillez reseigner l'email de l'entreprise");
        }
        if (dto.getNumTel() == null || dto.getNumTel().equals("")) {
            errors.add("Veuillez reseigner le numero de telephone de l'entreprise");
        }

        errors.addAll(AdresseValidator.validate(dto.getAdresse()));
        return errors;
    }

}
