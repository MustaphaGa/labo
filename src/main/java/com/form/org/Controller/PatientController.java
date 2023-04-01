package com.form.org.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.PatientApi;
import com.form.org.Services.PatientSecvice;
import com.form.org.dto.PatientDTO;

@RestController
public class PatientController implements PatientApi {
	

	private PatientSecvice patientService;
	
	@Autowired
	 public PatientController(PatientSecvice patientService) {
		this.patientService= patientService;
	}

	@Override
	public PatientDTO save(PatientDTO dto) {
	return patientService.save(dto);
	}

	@Override
	public PatientDTO findById(Integer idPatient) {
	return patientService.findById(idPatient) ;
	}
	
	@Override
	public PatientDTO findPatientByCodePatient(String codePatient) {
	return patientService.findByCodePatient(codePatient) ;
	}

	@Override
	public List<PatientDTO> findAll() {
	return patientService.findAll();
	}

	@Override
	public void delecte(Integer idPatient) {
	patientService.delete(idPatient);
	}

	

	

}
