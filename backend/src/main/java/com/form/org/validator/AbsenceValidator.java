package com.form.org.validator;

import com.form.org.dto.AbsenceDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AbsenceValidator {

    public static List<String> validate(AbsenceDTO absenceDTO){
        List<String> errors = new ArrayList<String>();

        if(absenceDTO.getDateDebut()==null) {
            errors.add("veuillez renseigner la date debut!!");
        }
        if(absenceDTO.getDateFin()==null) {
            errors.add("veuillez renseigner la date de la fin!!");
        }

        if(!StringUtils.hasLength(absenceDTO.getMotif())) {
            errors.add("veuillez renseigner le motif!!");
        }
        if(absenceDTO.getPieceJustificatifString()==null) {
            errors.add("veuillez inserer les pieces!!");
        }
        return errors;
    }
}
