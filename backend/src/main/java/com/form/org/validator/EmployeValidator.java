package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;

import com.form.org.dto.EmployeDTO;
import org.springframework.util.StringUtils;

public class EmployeValidator {

	
	public static List<String> validate(EmployeDTO employedto){
		List<String> errors = new ArrayList<String>();



		if(employedto == null) {
			errors.add("veuillez renseigner le nom !!");
			errors.add("veuillez renseigner le prénom  !!");
			errors.add("veuillez renseigner l'email  !!");
			errors.add("veuillez renseigner password  !!");
			errors.add("veuillez renseigner la confirmation de  password  !!");

			return errors;
		}
		  if(!StringUtils.hasLength(employedto.getNom())) {
			  errors.add("veuillez renseigner le nom de employe!!");
			}
		  if(!StringUtils.hasLength(employedto.getPrenom())) {
			  errors.add("veuillez renseigner le prénom de employe !!");
			}
		  if(!StringUtils.hasLength(employedto.getEmail())) {
			  errors.add("veuillez renseigner l'email de employe !!");
			}
		if(!StringUtils.hasLength(employedto.getCin())) {
			errors.add("veuillez renseigner cin de employe !!");
		}
		if(!StringUtils.hasLength(employedto.getTelephone())) {
			errors.add("veuillez renseigner telephone de employe !!");
		}
		if(!StringUtils.hasLength(employedto.getAdresse())) {
			errors.add("veuillez renseigner adresse de employe !!");
		}

		  if(!StringUtils.hasLength(employedto.getPassword())) {
			  errors.add("veuillez renseigner password de employe !!");
		}
		//  if(!StringUtils.hasLength(employedto.getConfirmPassword())) {
			//  errors.add("veuillez renseigner la confirmation de  password  !!");
		//	}
		return errors;
	}
}
