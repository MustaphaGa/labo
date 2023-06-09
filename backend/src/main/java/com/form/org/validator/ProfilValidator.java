package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.form.org.dto.RolesDTO;

public class ProfilValidator {
	
	public static List<String>validate(RolesDTO dto){
		List<String> errors = new ArrayList<String>();	
//        if(dto == null) {	
//		  errors.add("veuillez renseigner le nom de profil!!");
//		  errors.add("veuillez renseigner le droit de profil!!");
//		  errors.add("veuillez renseigner l'utilisateur!!");
//		  return errors;}
			
		  if(!StringUtils.hasLength(dto.getRoleName())) {
        	  errors.add("veuillez renseigner le nom de profil!!");
		}  
		 
		  
		  if(dto.getEmploye()==null) {
			 errors.add("veuillez renseigner l'utilisateur!!");
			}
		 return errors;
	}
}
