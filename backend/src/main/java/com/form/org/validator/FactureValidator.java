package com.form.org.validator;

import java.util.ArrayList;

import java.util.List;
import com.form.org.dto.FactureDTO;


public class FactureValidator {
	public static List<String> validate(FactureDTO factureDTO){
		List<String> errors = new ArrayList<String>();
		
		if(factureDTO == null) {
			errors.add("veuillez renseigner la date du facture!!");
			errors.add("veuillez renseigner le montant !");
			errors.add("veuillez renseigner l'analyse medical svp!!");
			
			return errors;
		}
		
		
		if(factureDTO.getDateFacture()==null) {
			errors.add("veuillez renseigner la date du facture!!");
		}
		if(factureDTO.getMontant()==null) {
			errors.add("veuillez renseigner le montant !");
		}
		
		if(factureDTO.getAnalyseMedical()==null) {
		errors.add("veuillez renseigner l'analyse medical svp!!");
		}

		return errors;
    }
	}
