package com.form.org.Services.Imp;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.form.org.Repository.UtilisateurRepository;
import com.form.org.Services.UtilisateurService;
import com.form.org.dto.ChangerMotDePasseUtilisateurDTO;
import com.form.org.dto.UtilisateurDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.exception.InvalidOperationException;
import com.form.org.model.Utilisateur;
import com.form.org.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class UtilisateurServiceImp implements UtilisateurService {

	private UtilisateurRepository utilisateurRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UtilisateurServiceImp(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository= utilisateurRepository;
	}
	
	@Override
	public UtilisateurDTO save(UtilisateurDTO dto) {
		List<String> errors= UtilisateurValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("l'utilisateur n'est pas valide {}",dto);
			throw new InvalidEntityException("l'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
		}
		
		 if(userAlreadyExists(dto.getEmail())) {
		      throw new InvalidEntityException("Un autre utilisateur avec le meme email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
		          Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));
		    }

	    dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		return UtilisateurDTO.fromEntity(
			utilisateurRepository.save(
			UtilisateurDTO.toEntity(dto)));
	}
	 private boolean userAlreadyExists(String email) {
		    Optional<Utilisateur> user = utilisateurRepository.findUtilisateurByEmail(email);
		    return user.isPresent();
		  }

	@Override
	public UtilisateurDTO findById(Integer id) {
		if(id == null) {	
			log.error("utilisateur id is null");
			return null;
		}
		Optional<Utilisateur> utilisateur=utilisateurRepository.findById(id);
		
		return Optional.of(UtilisateurDTO.fromEntity(utilisateur.get())).orElseThrow(() ->
		       new EntityNotFoundException(
				"Aucun utilisateur avec l'ID ="+ id +"n'été trouve dans la BDD",
				ErrorCodes.UTILISATEUR_NOT_FOUND)
		);
	}

	@Override
	public List<UtilisateurDTO> findAll() {
		return utilisateurRepository.findAll().stream()
				.map(UtilisateurDTO :: fromEntity)
				.collect(Collectors.toList());
	}
	@Override
	public void delete(Integer id) {
		if(id == null) {	
			log.error(" utilisateur id is null");
			return ;
		}
		utilisateurRepository.deleteById(id);
		
	}

	@Override
	public UtilisateurDTO findByEmail(String email) {
		return utilisateurRepository.findUtilisateurByEmail(email)
				.map(UtilisateurDTO :: fromEntity)
				.orElseThrow(()-> new EntityNotFoundException(
						"Aucun utilisateur avec l'email = " + email + " n'ete trouve dans la BDD", 
						ErrorCodes.UTILISATEUR_NOT_FOUND)
				);
	}

	@Override
	public UtilisateurDTO changerMotDePasse(ChangerMotDePasseUtilisateurDTO dto) {
		validate(dto);
	    Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(dto.getId());
	    if (utilisateurOptional.isEmpty()) {
	      log.warn("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getId());
	      throw new EntityNotFoundException("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getId(), ErrorCodes.UTILISATEUR_NOT_FOUND);
	    }

	    Utilisateur utilisateur = utilisateurOptional.get();
	    utilisateur.setPassword(passwordEncoder.encode(dto.getPassword()));

	    return UtilisateurDTO.fromEntity(
	        utilisateurRepository.save(utilisateur)
	    );
	  }

	  private void validate(ChangerMotDePasseUtilisateurDTO dto) {
	    if (dto == null) {
	      log.warn("Impossible de modifier le mot de passe avec un objet NULL");
	      throw new InvalidOperationException("Aucune information n'a ete fourni pour pouvoir changer le mot de passe",
	          ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
	    }
	    if (dto.getId() == null) {
	      log.warn("Impossible de modifier le mot de passe avec un ID NULL");
	      throw new InvalidOperationException("ID utilisateur null:: Impossible de modifier le mote de passe",
	          ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
	    }
	    if (!StringUtils.hasLength(dto.getPassword()) || !StringUtils.hasLength(dto.getConfirmPassword())) {
	      log.warn("Impossible de modifier le mot de passe avec un mot de passe NULL");
	      throw new InvalidOperationException("Mot de passe utilisateur null:: Impossible de modifier le mote de passe",
	          ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
	    }
	    if (!dto.getPassword().equals(dto.getConfirmPassword())) {
	      log.warn("Impossible de modifier le mot de passe avec deux mots de passe different");
	      throw new InvalidOperationException("Mots de passe utilisateur non conformes:: Impossible de modifier le mote de passe",
	          ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
	    }
	  }
	
	}
	


