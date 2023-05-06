package com.form.org.Repository;

import com.form.org.model.RH;
import com.form.org.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RhRepository extends JpaRepository<RH, Integer> {
    Optional<RH> findByIdRh(Integer idRh);


}
