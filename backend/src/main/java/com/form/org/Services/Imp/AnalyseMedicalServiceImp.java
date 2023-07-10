package com.form.org.Services.Imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.org.Repository.AnalyseMedicalRepository;
import com.form.org.Services.AnalyseMedicalService;
import com.form.org.dto.AnalyseMedicalDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.AnalyseMedical;
import com.form.org.validator.AnalyseMedicalValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class AnalyseMedicalServiceImp implements AnalyseMedicalService {
	
	private AnalyseMedicalRepository analyseMedicalRepository;
	
	@Autowired
	public AnalyseMedicalServiceImp(AnalyseMedicalRepository analyseMedicalRepository) {
		
		this.analyseMedicalRepository=analyseMedicalRepository;
		
	}

	@Override
	public AnalyseMedicalDTO save(AnalyseMedicalDTO dto) {
		List<String> errors= AnalyseMedicalValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("l'Analyse medical n'est pas valide {}",dto);
			throw new InvalidEntityException("l'Analyse medical n'est pas valide", ErrorCodes.ANALYSE_MEDICAL_NOT_VALID, errors);
		}  
		return AnalyseMedicalDTO.fromEntity(
				analyseMedicalRepository.save(
                 AnalyseMedicalDTO.toEntity(dto) 
                 )
				);
	}

	@Override
	public AnalyseMedicalDTO findById(Integer idAnalyseMedical) {
		if(idAnalyseMedical == null) {	
			log.error("Analyse medical id is null");
			return null;
		}
		Optional<AnalyseMedical> analyseMedical=analyseMedicalRepository.findById(idAnalyseMedical);
		
		return Optional.of(AnalyseMedicalDTO.fromEntity(analyseMedical.get())).orElseThrow(() ->
	       new EntityNotFoundException(
			"Aucun analyseMedical avec l'ID ="+ idAnalyseMedical +"n'été trouve dans la BDD",
			ErrorCodes.ANALYSE_MEDICAL_NOT_FOUND)
	);
	}

	@Override
	public AnalyseMedicalDTO findByDateAnalyse(Date dateAnalyse) {
		if(dateAnalyse == null){
			log.error("patient Code is null");
			return null;	
		}
		Optional<AnalyseMedical> analyseMedical=analyseMedicalRepository.findAnalyseMedicalByDateAnalyse(dateAnalyse);
		
		return Optional.of(AnalyseMedicalDTO.fromEntity(analyseMedical.get())).orElseThrow(() ->
	     new EntityNotFoundException(
				"Aucun analyse  dans ce date ="+ dateAnalyse +"n'été trouve dans la BDD",
				ErrorCodes.ANALYSE_MEDICAL_NOT_FOUND)
			); 
	}

	@Override
	public Integer countAnalyseMedical() {
		return analyseMedicalRepository.countAnalyseMedical();
	}


	@Override
	public List<AnalyseMedicalDTO> findAll() {
		
		return analyseMedicalRepository.findAll().stream()
				.map(AnalyseMedicalDTO :: fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer idAnalyseMedical) {
		
		if(idAnalyseMedical == null) {	
			log.error("analyse medical id is null");
			return ;
	}
		analyseMedicalRepository.deleteById(idAnalyseMedical);
	}
}
