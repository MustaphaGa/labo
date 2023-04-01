package com.form.org.Services.Imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.org.Repository.ReservationRepository;
import com.form.org.Services.ReservationService;
import com.form.org.dto.ReservationDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Reservation;
import com.form.org.validator.ReservationValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class ReservationServiceImp implements ReservationService{

	private ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationServiceImp( ReservationRepository reservationRepository) {
		this.reservationRepository= reservationRepository;
	}
	@Override
	public ReservationDTO save(ReservationDTO dto) {
		List<String> errors= ReservationValidator.validate(dto);
		if(!errors.isEmpty()) {
		log.error("la reservation n'est pas valide {}",dto);
		throw new InvalidEntityException("la reservation n'est pas valide",
		ErrorCodes.RESERVATION_NOT_VALID, errors);
		}
		return ReservationDTO.fromEntity(
				reservationRepository.save(
				ReservationDTO.toEntity(dto)));
	    }

	@Override
	public ReservationDTO findById(Integer idReservation) {
		if(idReservation == null) {	
			log.error("reservation id is null");
			return null;
		}
		Optional<Reservation> reservation=reservationRepository.findById(idReservation);
		
		return Optional.of(ReservationDTO.fromEntity(reservation.get())).orElseThrow(() ->
		       new EntityNotFoundException(
				"Aucun reservation avec l'ID ="+ idReservation +"n'été trouve dans la BDD",
				ErrorCodes.RESERVATION_NOT_FOUND)
		);
	}

	@Override
	public ReservationDTO findByDateReservation(Date dateReservation) {
		if(dateReservation == null){
			log.error(" date de reservation null");
			return null;	
		}
		
		Optional<Reservation> reservation=reservationRepository.findByDateReservation(dateReservation);
		
		return Optional.of(ReservationDTO.fromEntity(reservation.get())).orElseThrow(() ->
		     new EntityNotFoundException(
					"Aucun reservation avec cette date ="+ dateReservation +"n'été trouve dans la BDD",
					ErrorCodes.RESERVATION_NOT_FOUND)
				); 
	}

	@Override
	public List<ReservationDTO> findAll() {
		return reservationRepository.findAll().stream()
				.map(ReservationDTO :: fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer idReservation) {
		if(idReservation == null) {	
			log.error("reservation id is null");
			return ;
		}
		
		reservationRepository.deleteById(idReservation);
		
	}

}
