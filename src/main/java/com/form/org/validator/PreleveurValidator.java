package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.form.org.dto.PreleveurDTO;


public class PreleveurValidator {
	
	public static List<String> validate(PreleveurDTO preleveurDTO){
		
	
		List<String> errors = new ArrayList<String>();
		if(preleveurDTO == null) {
			
			errors.add("veuillez renseigner le nom de preleveur!!");
			errors.add("veuillez renseigner le prenom de preleveur!!");
			errors.add("veuillez renseigner l'email de preleveur!!");
			errors.add("veuillez renseigner le sexe de preleveur!!");
			errors.add("veuillez renseigner le telephone de preleveur!!");
			errors.add("veuillez renseigner la specialite de preleveur!!");
			errors.add("veuillez renseigner l'analyse medical!!");
			return errors;		
		}
		
		
          if(!StringUtils.hasLength(preleveurDTO.getNom())) {
        	  errors.add("veuillez renseigner le nom de preleveur!!");
		}
		
           if(!StringUtils.hasLength(preleveurDTO.getPrenom())) {
        	   errors.add("veuillez renseigner le prenom de preleveur!!");
		}
		
        if(!StringUtils.hasLength(preleveurDTO.getEmail())) {
        	errors.add("veuillez renseigner l'email de preleveur!!");
		}
        
        if(!StringUtils.hasLength(preleveurDTO.getSexe())) {
        	errors.add("veuillez renseigner le sexe de preleveur!!");
		}
        
        if(!StringUtils.hasLength(preleveurDTO.getTelephone())) {
        errors.add("veuillez renseigner le telephone de preleveur!!");
        }
        
        if(!StringUtils.hasLength(preleveurDTO.getSpecialite())) {
        	errors.add("veuillez renseigner la specialite de preleveur!!");;
            }
        
		if(preleveurDTO.getAnalyseMedical()==null) {
			errors.add("veuillez renseigner l'analyse medical!!");
		}
		
		return errors;
	}
}
