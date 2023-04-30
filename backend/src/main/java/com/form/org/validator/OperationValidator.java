package com.form.org.validator;

import com.form.org.dto.OperationDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OperationValidator {


    public static List<String> validate(OperationDTO operationDTO){
        List<String> errors = new ArrayList<String>();

        if(operationDTO == null) {
            errors.add("veuillez renseigner le type!");
            errors.add("veuillez renseigner la date !");



            return errors;
        }


        if(!StringUtils.hasLength(operationDTO.getTypeOperation())) {
            errors.add("veuillez renseigner le type!");
        }

        if(operationDTO.getDateOperation()==null) {
            errors.add("veuillez renseigner la date!!");
        }
        return errors;


    }
}
