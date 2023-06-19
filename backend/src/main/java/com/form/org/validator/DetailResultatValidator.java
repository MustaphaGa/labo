package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.form.org.dto.DetailResultatDTO;

public class DetailResultatValidator {
	
	public static List<String> validate(DetailResultatDTO detailResultatDTO){
		
		List<String> errors = new ArrayList<String>();
		
		if(detailResultatDTO == null) {
			errors.add("veuillez renseigner la description!!");
			errors.add("veuillez renseigner la valeur!!");
			errors.add("veuillez renseigner le biologiste!!");
			errors.add("veuillez renseigner l'analyse medical!!");
			
			return errors;
		}
		
		
		if(!StringUtils.hasLength(detailResultatDTO.getDescription())) {
			errors.add("veuillez renseigner la description!!");
		}

		
		if(detailResultatDTO.getBiologiste()==null) {
			errors.add("veuillez renseigner le biologiste!!");
				
		}
		if(detailResultatDTO.getAnalyseMedical()==null) {
			errors.add("veuillez renseigner l'analyse medical!!");
				
		}
		
		return errors;
	}
}
