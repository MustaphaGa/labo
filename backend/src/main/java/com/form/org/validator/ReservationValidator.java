package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.form.org.dto.ReservationDTO;


public class ReservationValidator {
	
	public static List<String> validate(ReservationDTO reservationDTO){
		List<String> errors = new ArrayList<String>();
		
//		if(reservationDTO == null) {
//			errors.add("veuillez renseigner la date de reservation!!");
//			errors.add("veuillez renseigner la description!!");
//			errors.add("veuillez renseigner la patient!!");
//			return errors;
//		}
		
		if(reservationDTO.getDateReservation()==null) {
			errors.add("veuillez renseigner la date de reservation!!");
		}
		
	    if(!StringUtils.hasLength(reservationDTO.getDescription())) {
			errors.add("veuillez renseigner la description de reservation!!");
		}
		if(reservationDTO.getPatient()==null) {
			errors.add("veuillez renseigner la patient!!");
		}
		return errors;
	}
     
}
