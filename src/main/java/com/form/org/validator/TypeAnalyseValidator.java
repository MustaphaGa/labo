package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.form.org.dto.TypeAnalyseDTO;

public class TypeAnalyseValidator {
	
	public static List<String> validate(TypeAnalyseDTO typeAnalyseDTO){
		List<String> errors = new ArrayList<String>();
		
		if(typeAnalyseDTO == null) {
			
			errors.add("veuillez renseigner le type d'analyse!!");
			return errors;
		}
		
		if(!StringUtils.hasLength(typeAnalyseDTO.getTypeAnalyse())) {
			errors.add("veuillez renseigner le type d'analyse!!");
		}
		
		
		
		return errors;
	}

}
