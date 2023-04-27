package com.form.org.validator;

import com.form.org.dto.AbsenceDTO;
import com.form.org.dto.CongeDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CongeValidator {

    public static List<String> validate(CongeDTO congeDTO){
        List<String> errors = new ArrayList<String>();

        if(congeDTO.getDateDebut()==null) {
            errors.add("veuillez renseigner la date debut!!");
        }
        if(congeDTO.getDateFin()==null) {
            errors.add("veuillez renseigner la date de la fin!!");
        }

        return errors;
    }
}
