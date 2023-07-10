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

		
		if(detailResultatDTO.getValeur1()==null) {
			errors.add("veuillez renseigner la valeur1!!");
				
		}
		if(detailResultatDTO.getValeur2()==null) {
			errors.add("veuillez renseigner la valeur2!!");

		}
		if(detailResultatDTO.getValeur3()==null) {
			errors.add("veuillez renseigner la valeur3!!");

		}
		if(detailResultatDTO.getValeur4()==null) {
			errors.add("veuillez renseigner la valeur4!!");

		}
		if(detailResultatDTO.getValeur5()==null) {
			errors.add("veuillez renseigner la valeur5!!");

		}
		if(detailResultatDTO.getValeur6()==null) {
			errors.add("veuillez renseigner la valeur6!!");

		}
		if(detailResultatDTO.getValeur7()==null) {
			errors.add("veuillez renseigner la valeur7!!");

		}
		if(detailResultatDTO.getValeur8()==null) {
			errors.add("veuillez renseigner la valeur8!!");

		}
		if(detailResultatDTO.getValeur9()==null) {
			errors.add("veuillez renseigner la valeur9!!");

		}
		if(detailResultatDTO.getValeur10()==null) {
			errors.add("veuillez renseigner la valeur10!!");

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
