package com.form.org.Services.Imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.form.org.Repository.ProfilRepository;
import com.form.org.Services.ProfilService;
import com.form.org.dto.ProfilDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Profil;
import com.form.org.validator.ProfilValidator;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j 
public class ProfilServiceImp implements ProfilService{
	
	private ProfilRepository profilRepository;
	
	@Autowired
	public ProfilServiceImp(ProfilRepository profilRepository) {
		this.profilRepository = profilRepository;
		
	}

	@Override
	public ProfilDTO save(ProfilDTO dto) {
		List<String> errors= ProfilValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error(" profil n'est pas valide {}",dto);
			throw new InvalidEntityException("profil n'est pas valide", ErrorCodes.PROFIL_NOT_VALID, errors);
		}
		return  ProfilDTO.fromEntity(profilRepository.save(
		ProfilDTO.toEntity(dto)	
						)
				);
	}

	@Override
	public ProfilDTO findById(Integer idProfil) {
		if(idProfil == null) {	
			log.error("profil id is null");
			return null;
		}
		Optional<Profil> profil=profilRepository.findById(idProfil);

		return Optional.of(ProfilDTO.fromEntity(profil.get())).orElseThrow(() ->
		       new EntityNotFoundException(
				"Aucun Profil avec l'ID ="+ idProfil +"n'été trouve dans la BDD",
				ErrorCodes.PROFIL_NOT_FOUND)
		);
	}

	@Override
	public List<ProfilDTO> findAll() {
		return profilRepository.findAll().stream()
				.map(ProfilDTO :: fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer idProfil) {
		if(idProfil == null) {	
			log.error("profil id is null");
			return ;
		}	
		profilRepository.deleteById(idProfil);
		
	}

}
