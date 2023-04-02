package com.form.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.AnalyseMedical;
import com.form.org.model.Reservation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ReservationDTO {
	
	private Integer idReservation;
	private Date dateReservation;
	private String description;
	
	private PatientDTO patient;
	
	@JsonIgnore
	private List<AnalyseMedical> analyseMedicals;
	
	
	
	public static ReservationDTO fromEntity(Reservation reservation) {
		
		if(reservation == null) {
			return null;
		}
		return ReservationDTO.builder()	
			.idReservation(reservation.getIdReservation())
			.dateReservation(reservation.getDateReservation())
			.description(reservation.getDescription())
			.patient(PatientDTO.fromEntity(reservation.getPatient()))
			.build();
	}
    
	public static Reservation toEntity(ReservationDTO reservationDTO) {
		if(reservationDTO == null) {	
			return null;
			}
		Reservation reservation = new Reservation();
		reservation.setIdReservation(reservationDTO.getIdReservation());	
		reservation.setDateReservation(reservationDTO.getDateReservation());
		reservation.setDescription(reservationDTO.getDescription());  
		reservation.setPatient(PatientDTO.toEntity(reservationDTO.getPatient()));
		return reservation;	
	}

	

	
}
