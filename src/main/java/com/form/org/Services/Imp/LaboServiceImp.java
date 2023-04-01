package com.form.org.Services.Imp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.org.Repository.LaboRepository;
import com.form.org.Repository.ProfilRepository;
import com.form.org.Services.LaboService;
import com.form.org.Services.UtilisateurService;
import com.form.org.dto.LaboDTO;
import com.form.org.dto.ProfilDTO;
import com.form.org.dto.UtilisateurDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Labo;
import com.form.org.validator.LaboValidator;

import lombok.extern.slf4j.Slf4j;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j 
public class LaboServiceImp  implements LaboService{
	
	private LaboRepository laboRepository;
	private UtilisateurService utilisateurService;
	private ProfilRepository  profilRepository;
	
	@Autowired
	public LaboServiceImp (LaboRepository laboRepository,UtilisateurService utilisateurService,
			ProfilRepository  profilRepository) {
		this.laboRepository=laboRepository;
		this.utilisateurService=utilisateurService;
		this.profilRepository=profilRepository;
	}

	@Override
	public LaboDTO save(LaboDTO dto) {
		List<String> errors = LaboValidator.validate(dto);
	    if (!errors.isEmpty()) {
	      log.error("labo is not valid {}", dto);
	      throw new InvalidEntityException("labo n'est pas valide", ErrorCodes.LABO_NOT_VALID, errors);
	}
	    
	    LaboDTO savedLabo = LaboDTO.fromEntity(
	    laboRepository.save(LaboDTO.toEntity(dto))
	        );

	        UtilisateurDTO utilisateur =fromLabo(savedLabo);

	        UtilisateurDTO savedUser = utilisateurService.save(utilisateur);
	        
	        	ProfilDTO  profilDTO = ProfilDTO.builder()
	            .nomProfil("admin")
	            .utilisateur(savedUser)
	            .build();

	        profilRepository.save(ProfilDTO.toEntity(profilDTO));

	        return  savedLabo;
	      }

	      private UtilisateurDTO fromLabo(LaboDTO dtoLabo) {
	        return UtilisateurDTO.builder()  
	            .nom(dtoLabo.getNomLabo())
	            .prenom(dtoLabo.getCodeFiscal())
	            .email(dtoLabo.getEmail())
	            .password(GeRendPass())
	            .confirmPassword(dtoLabo.getSiteWeb())
	            .labo(dtoLabo)  
	            .build();
	      }
	      private String GeRendPass() {
	        return "khalid";
	      }
	    
	@Override
	public LaboDTO findById(Integer idLabo) {	
		if(idLabo == null) {	
			log.error("labo id is null");
			return null;
		}
		Optional<Labo> labo=laboRepository.findById(idLabo);
		
		return Optional.of(LaboDTO.fromEntity(labo.get())).orElseThrow(() ->
		       new EntityNotFoundException(
				"Aucun patient avec l'ID ="+ idLabo +"n'été trouve dans la BDD",
				ErrorCodes.PRELEVEUR_NOT_FOUND)
		);
	}

	@Override
	public List<LaboDTO> findAll() {	
	return null;
	}

	@Override
	public void delete(Integer idLabo) {
		
		
	}

}
