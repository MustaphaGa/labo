package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.form.org.dto.BiologisteDTO;

public class BiologisteValidator {
	
	public static List<String> validate(BiologisteDTO biologisteDTO){
		List<String> errors = new ArrayList<String>();
		
		if(biologisteDTO == null) {
			errors.add("veuillez renseigner le nom de biologiste!!");
			errors.add("veuillez renseigner le prénom de biologiste !!");
			errors.add("veuillez renseigner l'email de biologiste !!");
			errors.add("veuillez renseigner login de biologiste !!");
			errors.add("veuillez renseigner password de biologiste !!");
			errors.add("veuillez renseigner le sexe de biologiste !!");
			errors.add("veuillez renseigner le telephone de biologiste !!");
			errors.add("veuillez renseigner le code de biologiste !!");
			errors.add("veuillez renseigner le service de biologiste !!");
			errors.add("veuillez renseigner le departement !!");
			
			return errors;
		}
		
		  if(!StringUtils.hasLength(biologisteDTO.getNom())) {
			  errors.add("veuillez renseigner le nom de biologiste!!");
			}
		  if(!StringUtils.hasLength(biologisteDTO.getPrenom())) {
			  errors.add("veuillez renseigner le prénom de biologiste !!");
			}
		  if(!StringUtils.hasLength(biologisteDTO.getEmail())) {
			  errors.add("veuillez renseigner l'email de biologiste !!");
			}

		  if(!StringUtils.hasLength(biologisteDTO.getSexe())) {
			  errors.add("veuillez renseigner le sexe de biologiste !!");
			}
		  if(!StringUtils.hasLength(biologisteDTO.getTelephone())) {
			  errors.add("veuillez renseigner le telephone de biologiste !!");
			}
		  if(!StringUtils.hasLength(biologisteDTO.getCodeBiologiste())) {
			  errors.add("veuillez renseigner le code de biologiste !!");
			}
		  if(!StringUtils.hasLength(biologisteDTO.getService())) {
			  errors.add("veuillez renseigner le service de biologiste !!");
			}
		
			if(biologisteDTO.getDepartement()==null) {
				errors.add("veuillez renseigner le departement !!");
			}
			
		return errors;
	}
}
