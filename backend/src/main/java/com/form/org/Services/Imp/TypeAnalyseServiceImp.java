package com.form.org.Services.Imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.form.org.Repository.TypeAnalyseRepository;
import com.form.org.Services.TypeAnalyseService;
import com.form.org.dto.TypeAnalyseDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.TypeAnalyse;
import com.form.org.validator.TypeAnalyseValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class TypeAnalyseServiceImp implements TypeAnalyseService{

	private TypeAnalyseRepository typeAnalyseRepository;
	
	@Autowired
	public TypeAnalyseServiceImp(TypeAnalyseRepository typeAnalyseRepository) {
		
	this.typeAnalyseRepository= typeAnalyseRepository;
	}
	
	@Override
	public TypeAnalyseDTO save(TypeAnalyseDTO dto) {
	List<String> errors= TypeAnalyseValidator.validate(dto);
	if(!errors.isEmpty()) {
	log.error("le type d'analyse  n'est pas valide {}",dto);
	throw new InvalidEntityException("le type d'analyse  n'est pas valide", ErrorCodes.TYPE_ANALYSE_NOT_VALID, errors);
	}
	return TypeAnalyseDTO.fromEntity(
	typeAnalyseRepository.save(
	TypeAnalyseDTO.toEntity(dto)	
						)
				);
		
	}

	@Override
	public TypeAnalyseDTO findById(Integer idTypeAnalyse) {
		if(idTypeAnalyse == null) {	
		log.error("patient id is null");
		return null;
		}
		Optional<TypeAnalyse> typeAnalyse=typeAnalyseRepository.findById(idTypeAnalyse);
		
		return Optional.of(TypeAnalyseDTO.fromEntity(typeAnalyse.get())).orElseThrow(() ->
		new EntityNotFoundException(
		"Aucun type d'analyse  avec l'ID ="+ idTypeAnalyse +"n'été trouve dans la BDD",
		ErrorCodes.TYPE_ANALYSE_NOT_FOUND)
		);
		
	}

	@Override
	public TypeAnalyseDTO findByTypeAnalyse(String typeAnalyse) {
		if(!StringUtils.hasLength(typeAnalyse)){
			log.error("type Analyse is null");
			return null;	
		}
		
		Optional<TypeAnalyse> type_Analyse = typeAnalyseRepository.findByTypeAnalyse(typeAnalyse);
		
		return Optional.of(TypeAnalyseDTO.fromEntity(type_Analyse.get())).orElseThrow(() ->
		new EntityNotFoundException(
		"Aucun type d'analyse avec ce type ="+ typeAnalyse +"n'été trouve dans la BDD",
		ErrorCodes.TYPE_ANALYSE_NOT_FOUND)
				); 
	
	}

	@Override
	public List<TypeAnalyseDTO> findAll() {
		return typeAnalyseRepository.findAll().stream()
			    .map(TypeAnalyseDTO :: fromEntity)
				.collect(Collectors.toList());
		
	}

	@Override
	public void delete(Integer idTypeAnalyse) {
		if(idTypeAnalyse == null) {	
		log.error("typeAnalyse id is null");
		return ;
		}
		typeAnalyseRepository.deleteById(idTypeAnalyse);
		
	}

}
