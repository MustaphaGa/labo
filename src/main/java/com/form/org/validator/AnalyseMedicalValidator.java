package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.form.org.dto.AnalyseMedicalDTO;

public class AnalyseMedicalValidator {
	
	public static List<String> validate(AnalyseMedicalDTO dto){
		List<String> errors = new ArrayList<String>();
		if(dto == null) {
			errors.add("veuillez renseigner la date d'analyse!!");
			errors.add("veuillez renseigner la description !!");
			errors.add("veuillez renseigner la prix d'analyse !!");
			errors.add("veuillez renseigner le  type d'analyse !!");
		    errors.add("veuillez renseigner la reservation !!");
			return errors;
		}
		
		 if(dto.getDateAnalyse()==null) {
			  errors.add("veuillez renseigner la date d'analyse!!");;
		 }
		
		  if(!StringUtils.hasLength(dto.getDescriprtion())) {
			  errors.add("veuillez renseigner la description !!");
			}
		  
		  if(dto.getPrixAnalyse()==null) {
			  errors.add("veuillez renseigner le  prix d'analyse !!");
			}
		  
		  if(dto.getTypeAnalyse()==null) {
			  errors.add("veuillez renseigner le  type d'analyse !!");
			}
		  
		  if(dto.getReservation()==null) {
			  errors.add("veuillez renseigner la reservation !!");
			}
		  return errors;
	}
}
