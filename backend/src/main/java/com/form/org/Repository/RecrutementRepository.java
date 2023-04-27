package com.form.org.Repository;

import com.form.org.model.Absence;
import com.form.org.model.Recrutement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface RecrutementRepository extends JpaRepository<Recrutement, Integer> {
    Optional<Recrutement> findByIdRecrutement(Integer idRecrutement);
    Optional<Recrutement> findByDateRecrutement(Date dateRecrutement);
}
