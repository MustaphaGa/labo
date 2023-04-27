package com.form.org.validator;

import com.form.org.dto.MouvementDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MouvementValidator {
    public static List<String> validate(MouvementDTO mouvementDTO){
        List<String> errors = new ArrayList<String>();


        if(mouvementDTO.getDetailMouvement()==null) {
            errors.add("veuillez renseigner les details!!");
        }

        if(!StringUtils.hasLength(mouvementDTO.getTypeMouvement())) {
            errors.add("veuillez renseigner la description du mouvement!!");
        }
        if(mouvementDTO.getFrais()==0) {
            errors.add("veuillez renseigner les frais!!");
        }
        return errors;
    }
}
