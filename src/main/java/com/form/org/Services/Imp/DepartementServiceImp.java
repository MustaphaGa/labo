package com.form.org.Services.Imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.form.org.Repository.BiologisteRepository;
import com.form.org.Repository.DepartementRepository;
import com.form.org.Services.DepartementService;
import com.form.org.dto.DepartementDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Departement;
import com.form.org.validator.DepartementValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class DepartementServiceImp implements DepartementService{
	
	private DepartementRepository depatementRepository;
	
	@Autowired
	public  DepartementServiceImp(DepartementRepository depatementRepository,BiologisteRepository biologisteRepository) {
		this.depatementRepository=depatementRepository;
	
	}
	

	@Override
	public DepartementDTO save(DepartementDTO dto) {
		
		List<String> errors= DepartementValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("la departement n'est pas valide {}",dto);
			throw new InvalidEntityException("la departement n'est pas valide", ErrorCodes.DEPARTEMENT_NOT_VALID, errors);
		}
		return DepartementDTO.fromEntity(
				depatementRepository.save(DepartementDTO.toEntity(dto)	
						)
				);
	}

	@Override
	public DepartementDTO findById(Integer idDepartement) {
		if(idDepartement == null) {	
			log.error("depatement id is null");
			return null;
		}
		Optional<Departement> departement=depatementRepository.findById(idDepartement);
		
		return Optional.of(DepartementDTO.fromEntity(departement.get())).orElseThrow(() ->
		       new EntityNotFoundException(
				"Aucun departement avec l'ID ="+ idDepartement +"n'été trouve dans la BDD",
				ErrorCodes.DEPARTEMENT_NOT_FOUND)
		);
	}

	@Override
	public DepartementDTO findByNomDeDepartement(String nomDepartement) {
		if(!StringUtils.hasLength(nomDepartement)){
			log.error("Departement name is null");
			return null;	
		}
		
		Optional<Departement> departement=depatementRepository.findDepartementByNomDepartement(nomDepartement);
		
		return Optional.of(DepartementDTO.fromEntity(departement.get())).orElseThrow(() ->
		     new EntityNotFoundException(
					"Aucun depatement avec le nom de departement ="+ nomDepartement +"n'été trouve dans la BDD",
					ErrorCodes.DEPARTEMENT_NOT_FOUND)
				); 
	}

	@Override
	public List<DepartementDTO> findAll() {
		
		return depatementRepository.findAll().stream()
				.map(DepartementDTO :: fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer idDepartement) {
		if(idDepartement == null) {	
		log.error("departement id is null");
		return ;
		}
		//List<Biologiste> biolo=biologisteRepository.findAllByDepartementId(idDepartement);
//		if(! biolo.isEmpty()) {
//			throw new InvalidEntityException("impossible de supprimer cette departement qui est deja utilise",
//					ErrorCodes.DEPARTEMENT_ALREADY_IN_USE);
		
		depatementRepository.deleteById(idDepartement);
		
	}

}
