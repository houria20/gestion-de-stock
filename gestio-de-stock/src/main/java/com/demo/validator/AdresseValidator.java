package com.demo.validator;

import java.util.ArrayList;
import java.util.List;

import com.demo.dto.AdresseDto;

public class AdresseValidator {

  public static List<String> validate(AdresseDto adresseDto) {
    List<String> errors = new ArrayList<>();

    if (adresseDto == null) {
      errors.add("Veuillez renseigner l'adresse 1'");
      errors.add("Veuillez renseigner la ville'");
      errors.add("Veuillez renseigner le pays'");
      errors.add("Veuillez renseigner le code postal'");
      return errors;
    }
    if (adresseDto.getAdresse1() == null || adresseDto.getAdresse1().equals("")) {
      errors.add("Veuillez renseigner l'adresse 1'");
    }
    if (adresseDto.getVille()==null|| adresseDto.getVille().equals("")) {
      errors.add("Veuillez renseigner la ville'");
    }
    if (adresseDto.getPays()==null|| adresseDto.getPays().equals("")) {
      errors.add("Veuillez renseigner le pays'");
    }
    if (adresseDto.getCodePostal()==null|| adresseDto.getCodePostal().equals("")) {
      errors.add("Veuillez renseigner le code postal'");
    }
    return errors;
  }

}
