package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.form.org.dto.DepartementDTO;

public class DepartementValidator {
	public static List<String> validate(DepartementDTO departementDTO){
		List<String> errors = new ArrayList<String>();
		
//		if(departementDTO == null) {
//			errors.add("veuillez renseigner le nom de departement!!");
//			return errors;	
//		}	
		
       if(!StringUtils.hasLength(departementDTO.getNomDepartement())) {
    	   errors.add("veuillez renseigner le nom de departement!!");
		}
	return errors;
	}
}
	
