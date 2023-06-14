package com.form.org.validator;
import com.form.org.dto.OperationDTO;
import java.util.ArrayList;
import java.util.List;

public class OperationValidator {


    public static List<String> validate(OperationDTO operationDTO)
    {
        List<String> errors = new ArrayList<String>();
        if(operationDTO == null)
        {
           // errors.add("veuillez renseigner la date d'operation!");
            //errors.add("veuillez renseigner le type d'operation! ");
            errors.add("veuillez renseigner l'annee! ");
            errors.add("veuillez renseigner le montant d'operation! ");
            errors.add("veuillez renseigner la description! ");
           // errors.add("veuillez renseigner le compte bancaire! ");
            return errors;
        }

            if(operationDTO.getAnnee()==null) {
            errors.add("veuillez renseigner l'annee! ");
        }
        if(operationDTO.getMontant()==null) {
            errors.add("veuillez renseigner le montant d'operation! ");
        }
        if(operationDTO.getDescription()==null) {
            errors.add("veuillez renseigner la description! ");
        }
/*
        if(operationDTO.getDateOperation()==null) {
            errors.add("veuillez renseigner la date d'operation!");
        }
        if(operationDTO.getTypeOperation()==null) {
            errors.add("veuillez renseigner le type d'operation! ");
        }

        if(operationDTO.getCompte()==null) {
            errors.add("veuillez renseigner le compte bancaire! ");
        }

 */

        return errors;


    }
}
