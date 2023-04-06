package com.form.org.Services.Imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.org.Repository.RolesRepository;
import com.form.org.Services.RolesService;
import com.form.org.dto.RolesDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Roles;
import com.form.org.validator.ProfilValidator;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j 
public class RolesServiceImp implements RolesService{
	
	private RolesRepository rolesRepository;
	
	@Autowired
	public RolesServiceImp(RolesRepository rolesRepository) {
		this.rolesRepository = rolesRepository;
		
	}

	@Override
	public RolesDTO save(RolesDTO dto) {
		List<String> errors= ProfilValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error(" profil n'est pas valide {}",dto);
			throw new InvalidEntityException("profil n'est pas valide", ErrorCodes.PROFIL_NOT_VALID, errors);
		}
		return  RolesDTO.fromEntity(rolesRepository.save(
				RolesDTO.toEntity(dto)	
						)
				);
	}

	@Override
	public RolesDTO findById(Integer idProfil) {
		if(idProfil == null) {	
			log.error("profil id is null");
			return null;
		}
		Optional<Roles> profil=rolesRepository.findById(idProfil);

		return Optional.of(RolesDTO.fromEntity(profil.get())).orElseThrow(() ->
		       new EntityNotFoundException(
				"Aucun Profil avec l'ID ="+ idProfil +"n'été trouve dans la BDD",
				ErrorCodes.PROFIL_NOT_FOUND)
		);
	}

	@Override
	public List<RolesDTO> findAll() {
		return rolesRepository.findAll().stream()
				.map(RolesDTO :: fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer idProfil) {
		if(idProfil == null) {	
			log.error("profil id is null");
			return ;
		}	
		rolesRepository.deleteById(idProfil);
		
	}

}
