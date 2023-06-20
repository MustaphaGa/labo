package com.form.org.validator;

import com.form.org.dto.NatureOperationDTO;
import org.springframework.util.StringUtils;

import java.util.*;


public class NatureOperationValidator {
    public static List<String> validate(NatureOperationDTO dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null)
        {
            errors.add("Veuillez renseigner la libelle d'operation");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getLibNatureOperation()))
        {
            errors.add("Veuillez renseigner la libelle d'operation");
        }

        return errors;
    }
}
