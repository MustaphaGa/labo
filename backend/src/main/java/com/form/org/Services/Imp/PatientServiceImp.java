package com.form.org.Services.Imp;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.form.org.Repository.PatientRepository;
import com.form.org.Services.PatientSecvice;
import com.form.org.dto.PatientDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Patient;
import com.form.org.validator.PatientValidator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class PatientServiceImp implements PatientSecvice {
	
	private PatientRepository patientRepository;
	
    @Autowired
	public PatientServiceImp(PatientRepository patientRepository) {
		this.patientRepository=patientRepository;	
	}

	@Override
	public PatientDTO save(PatientDTO dto) {	
	List<String> errors= PatientValidator.validate(dto);
		if(!errors.isEmpty()) {
		log.error("la patient n'est pas valide {}",dto);
		throw new InvalidEntityException("la patient n'est pas valide", ErrorCodes.PATIENT_NOT_VALID, errors);
		}
		return PatientDTO.fromEntity(
				patientRepository.save(
				PatientDTO.toEntity(dto)	
						)
				);
	}

	@Override
	public PatientDTO findById(Integer idPatient) {	
		if(idPatient == null) {	
		log.error("patient id is null");
		return null;
		}
		Optional<Patient> patient=patientRepository.findById(idPatient);
		return Optional.of(PatientDTO.fromEntity(patient.get())).orElseThrow(() ->
		       new EntityNotFoundException(
				"Aucun patient avec l'ID ="+ idPatient +"n'été trouve dans la BDD",
				ErrorCodes.PATIENT_NOT_FOUND)
		);
	}

	@Override
	public PatientDTO findByCodePatient(String codePatient) {
		
		if(!StringUtils.hasLength(codePatient)){
			log.error("patient Code is null");
			return null;	
		}
		
		Optional<Patient> patient=patientRepository.findPatientByCodePatient(codePatient);
		
		return Optional.of(PatientDTO.fromEntity(patient.get())).orElseThrow(() ->
		     new EntityNotFoundException(
					"Aucun patient avec le Code Patient ="+ codePatient +"n'été trouve dans la BDD",
					ErrorCodes.PATIENT_NOT_FOUND)
				); 
	}

	@Override
	public List<PatientDTO> findAll() {
		return patientRepository.findAll().stream()
				.map(PatientDTO :: fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer idPatient) {
		if(idPatient == null) {	
		log.error("patient id is null");
		return ;
		}	
		patientRepository.deleteById(idPatient);
	}

}
