package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.form.org.dto.PatientDTO;


public class PatientValidator {
	
	public static List<String> validate(PatientDTO patientdto){
		List<String> errors = new ArrayList<String>();
		
		if(patientdto == null) {
			errors.add("veuillez renseigner cni de patient!!");
			errors.add("veuillez renseigner le nom de patient!!");
			errors.add("veuillez renseigner le prenom de patient!!");
			errors.add("veuillez renseigner l'email de patient!!");
			errors.add("veuillez renseigner le sexe de patient!!");
			errors.add("veuillez renseigner le telephone de patient!!");
			errors.add("veuillez renseigner le code de patient!!");
			errors.add("veuillez renseigner la date de naissance de patient!!");
			errors.add("veuillez renseigner l'adresse de patient!!");
		
			
			return errors;
		}
		
		
	if(!StringUtils.hasLength(patientdto.getCni())) {
		errors.add("veuillez renseigner cni de patient!!");
		}
	
	if(!StringUtils.hasLength(patientdto.getNom())) {
		errors.add("veuillez renseigner le nom de patient!!");
		}

	if(!StringUtils.hasLength(patientdto.getPrenom())) {
		errors.add("veuillez renseigner le prenom de patient!!");
		}
	
	if(!StringUtils.hasLength(patientdto.getEmail())) {
		errors.add("veuillez renseigner l'email de patient!!");
		}

	if(!StringUtils.hasLength(patientdto.getSexe())) {
		errors.add("veuillez renseigner l'adresse de patient!!");
		}
	
	if(!StringUtils.hasLength(patientdto.getTelephone())) {
		errors.add("veuillez renseigner le telephone de patient!!");
		}
	
	if(!StringUtils.hasLength(patientdto.getCodePatient())) {
		errors.add("veuillez renseigner le code de patient!!");
		}
	
	if(patientdto.getDateNaissance()== null) {
		errors.add("veuillez renseigner la date de naissance de patient!!");
		}
	
	if(!StringUtils.hasLength(patientdto.getAdressse())) {
		errors.add("veuillez renseigner l'adresse de patient!!");
		}
	
	return errors;

	}
	}
