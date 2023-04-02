package com.form.org.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form.org.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>  {
	
	Optional <Patient> findPatientByCodePatient(String codePatient);
	

}
