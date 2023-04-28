package com.form.org.validator;

import com.form.org.dto.RecrutementDTO;

import java.util.ArrayList;
import java.util.List;

public class RecrutementValidator {

    public static List<String> validate(RecrutementDTO recrutementDTO){
        List<String> errors = new ArrayList<String>();

//		if(recrutementDTO == null) {
//			errors.add("veuillez renseigner la date de reservation!!");
//			errors.add("veuillez renseigner la description!!");
//			errors.add("veuillez renseigner la patient!!");
//			return errors;
//		}

        if(recrutementDTO.getDateRecrutement()==null) {
            errors.add("veuillez renseigner la date de recrutement!!");
        }
        if(recrutementDTO.getTypeRecrutement()==null) {
            errors.add("veuillez renseigner le type de recrutement!!");
        }


        return errors;
    }
}
