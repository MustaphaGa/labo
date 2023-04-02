package com.form.org.Services.Imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.form.org.Repository.PreleveurRepository;
import com.form.org.Services.PreleveurService;
import com.form.org.dto.PreleveurDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Preleveur;
import com.form.org.validator.PreleveurValidator;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j 
public class PreleveurServiceImp implements PreleveurService{
	
	private PreleveurRepository preleveurRepositoy;
	
	@Autowired
    public PreleveurServiceImp(PreleveurRepository preleveurRepositoy) {
	    this.preleveurRepositoy= preleveurRepositoy;
	
}
	@Override
	public PreleveurDTO save(PreleveurDTO dto) {
	
		List<String> errors= PreleveurValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error(" preleveur n'est pas valide {}",dto);
			throw new InvalidEntityException(" preleveur n'est pas valide", ErrorCodes.PRELEVEUR_NOT_VALID, errors);
		}
		return PreleveurDTO.fromEntity(
			   preleveurRepositoy.save(
			   PreleveurDTO.toEntity(dto)	
						)
				);
	}

	@Override
	public PreleveurDTO findById(Integer idPreleveur) {
		if(idPreleveur == null) {	
			log.error("preleveur id is null");
			return null;
		}
		Optional<Preleveur> preleveur=preleveurRepositoy.findById(idPreleveur);
		
		return Optional.of(PreleveurDTO.fromEntity(preleveur.get())).orElseThrow(() ->
		       new EntityNotFoundException(
				"Aucun patient avec l'ID ="+ idPreleveur +"n'été trouve dans la BDD",
				ErrorCodes.PRELEVEUR_NOT_FOUND)
		);
	}

	@Override
	public PreleveurDTO findBySpecialite(String specialite) {
		if(!StringUtils.hasLength(specialite)){
			log.error("specialite  is null");
			return null;	
		}
		
		Optional<Preleveur> preleveur=preleveurRepositoy.findBySpecialite(specialite);
		
		return Optional.of(PreleveurDTO.fromEntity(preleveur.get())).orElseThrow(() ->
		     new EntityNotFoundException(
					"Aucun preleveur avec le Code Patient ="+ specialite +"n'été trouve dans la BDD",
					ErrorCodes.PRELEVEUR_NOT_FOUND)
				); 
	}

	@Override
	public List<PreleveurDTO> findAll() {
		return preleveurRepositoy.findAll().stream()
				.map(PreleveurDTO :: fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer idPreleveur) {
		if(idPreleveur == null) {	
			log.error("preleveur id is null");
			return ;
		}
		
		preleveurRepositoy.deleteById(idPreleveur);
		
	}

}
