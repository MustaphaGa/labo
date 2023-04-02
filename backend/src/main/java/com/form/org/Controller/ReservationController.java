package com.form.org.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.ReservationApi;
import com.form.org.Services.ReservationService;
import com.form.org.dto.ReservationDTO;
@RestController
public class ReservationController implements ReservationApi {
	
	private ReservationService reservationService;
	
   @Autowired
   public ReservationController(ReservationService reservationService) {
	this.reservationService= reservationService;
   }

	@Override
	public ReservationDTO save(ReservationDTO dto) {
		return reservationService.save(dto);
	}

	@Override
	public ReservationDTO findById(Integer idReservation) {
		return reservationService.findById(idReservation);
	}

	@Override
	public ReservationDTO findByDateReservation(Date dateReservation) {
		return reservationService.findByDateReservation(dateReservation);
	}

	@Override
	public List<ReservationDTO> findAll() {
		return reservationService.findAll();
	}

	@Override
	public void delete(Integer idReservation) {
		reservationService.delete(idReservation);
	}

}
