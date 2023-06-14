package com.form.org.validator;

import com.form.org.dto.CompteDTO;
import java.util.ArrayList;
import java.util.List;

public class CompteValidator {

    public static List<String> validate(CompteDTO compteDTO)
    {
        List<String> errors = new ArrayList<String>();
        if(compteDTO == null)
        {
            errors.add("veuillez renseigner le libeller de compte!");
            errors.add("veuillez renseigner le numéro de compte!");


            return errors;
        }

        if(compteDTO.getLibCompte()==null) {
            errors.add("veuillez renseigner le libeller de compte!");
        }

        if(compteDTO.getNumeroCompte()==null) {
            errors.add("veuillez renseigner le numéro de compte!");
        }

        return errors;


    }
}
