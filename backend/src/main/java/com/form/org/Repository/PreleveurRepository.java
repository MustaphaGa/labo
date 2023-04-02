package com.form.org.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.form.org.model.Preleveur;

public interface PreleveurRepository extends JpaRepository< Preleveur, Integer> {
	Optional <Preleveur>findBySpecialite(String specialite);
}
