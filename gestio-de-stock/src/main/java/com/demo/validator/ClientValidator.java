package com.demo.validator;

import com.demo.dto.ClientDto;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

  public static List<String> validate(ClientDto dto) {
    List<String> errors = new ArrayList<>();

    if (dto == null) {
      errors.add("Veuillez renseigner le nom du client");
      errors.add("Veuillez renseigner le prenom du client");
      errors.add("Veuillez renseigner le Mail du client");
      errors.add("Veuillez renseigner le numero de telephone du client");
      errors.addAll(AdresseValidator.validate(null));
      return errors;
    }

    if (dto.getNom()==null || dto.getNom().equals("")) {
      errors.add("Veuillez renseigner le nom du client");
    }
    if (dto.getPrenom()==null || dto.getPrenom().equals("")) {
      errors.add("Veuillez renseigner le prenom du client");
    }
    if (dto.getMail()==null || dto.getMail().equals("")) {
      errors.add("Veuillez renseigner le Mail du client");
    }
    if (dto.getNumTel()==null || dto.getNumTel().equals("")) {
      errors.add("Veuillez renseigner le numero de telephone du client");
    }
    errors.addAll(AdresseValidator.validate(dto.getAdresse()));
    return errors;
  }

}
