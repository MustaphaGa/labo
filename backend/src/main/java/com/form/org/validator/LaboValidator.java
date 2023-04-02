package com.form.org.validator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.form.org.dto.LaboDTO;


public class LaboValidator {
	
public static List<String> validate(LaboDTO dto) {
		    List<String> errors = new ArrayList<>();
		    if (dto == null) {
		      errors.add("Veuillez renseigner le nom de labo");
		      errors.add("Veuillez reseigner le code fiscal de labo");
		      errors.add("Veuillez reseigner l'email de labo");
return errors;
}
		    if (!StringUtils.hasLength(dto.getNomLabo())) {
		        errors.add("Veuillez renseigner le nom de labo");
		      }
		    
		      if (!StringUtils.hasLength(dto.getCodeFiscal())) {
		        errors.add("Veuillez reseigner le code fiscal de labo");
		      }
		      if (!StringUtils.hasLength(dto.getEmail())) {
		        errors.add("Veuillez reseigner l'email de labo");
		      }	    
		    
			return errors;
}}