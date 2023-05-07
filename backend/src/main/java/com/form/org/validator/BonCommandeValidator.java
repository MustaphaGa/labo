package com.form.org.validator;

import com.form.org.dto.BiologisteDTO;
import com.form.org.dto.BonCommandeDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BonCommandeValidator {
    public static List<String> validate(BonCommandeDTO bonCommandeDTO){
        List<String> errors = new ArrayList<String>();

        if(bonCommandeDTO == null) {
            errors.add("veuillez renseigner le dateCommande de commande!!");
            errors.add("veuillez renseigner le prix de commande !!");


            return errors;
        }

        if(bonCommandeDTO.getDateCommande()==null) {
            errors.add("veuillez renseigner lDateCommande!!");
        }
        if(bonCommandeDTO.getPrix()==0) {
            errors.add("veuillez renseigner Prix!!");
        }



        return errors;
    }
}
