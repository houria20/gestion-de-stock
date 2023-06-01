package com.demo.validator;

import com.demo.dto.UtilisateurDto;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();

        if (utilisateurDto == null) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (utilisateurDto.getNom() == null || utilisateurDto.getNom().equals("")) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if (utilisateurDto.getPrenom() == null || utilisateurDto.getPrenom().equals("")) {
            errors.add("Veuillez renseigner le prenom d'utilisateur");
        }
        if (utilisateurDto.getEmail() == null || utilisateurDto.getEmail().equals("")) {
            errors.add("Veuillez renseigner l'email d'utilisateur");
        }
        if (utilisateurDto.getMoteDePasse() == null || utilisateurDto.getMoteDePasse().equals("")) {
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
        }
        if (utilisateurDto.getDateDeNaissance() == null) {
            errors.add("Veuillez renseigner la date de naissance d'utilisateur");
        }
        errors.addAll(AdresseValidator.validate(utilisateurDto.getAdresse()));
        return errors;
    }

}
