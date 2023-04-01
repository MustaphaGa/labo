package com.form.org.Services;

import java.util.Date;
import java.util.List;

import com.form.org.dto.ReservationDTO;

public interface ReservationService {
	
	ReservationDTO save(ReservationDTO dto);
	
	ReservationDTO findById(Integer idReservation);
		
	ReservationDTO findByDateReservation(Date dateReservation);
		
	List<ReservationDTO>findAll(); 
		
    void delete(Integer idReservation);

}
