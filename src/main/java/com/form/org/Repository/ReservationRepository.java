package com.form.org.Repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form.org.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	Optional<Reservation> findByDateReservation(Date dateReservation);
	
	

}
