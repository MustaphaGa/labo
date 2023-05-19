package com.form.org.Repository;

import com.form.org.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
    Optional<Absence> findByidAbsence(Integer idAbsence);
    Optional<Absence> findByMotif(String motif);

}
