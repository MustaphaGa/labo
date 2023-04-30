package com.form.org.Repository;

import com.form.org.model.Absence;
import com.form.org.model.BilanFinancier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BilanFinancierRepository extends JpaRepository<BilanFinancier, Integer> {
    Optional<BilanFinancier> findByidBilan(Integer idBilan);


}
