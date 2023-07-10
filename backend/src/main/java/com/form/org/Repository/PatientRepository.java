package com.form.org.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form.org.model.Patient;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Integer>  {
	
	Optional <Patient> findPatientByCodePatient(String codePatient);

	@Query("SELECT COUNT(p) FROM Patient  p")
	Integer countPatient();
	

}
