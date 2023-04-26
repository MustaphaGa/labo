package com.form.org.Services.Imp;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.form.org.Repository.EmployeRepository;
import com.form.org.Services.EmployeService;
import com.form.org.dto.ChangerMotDePasseUtilisateurDTO;
import com.form.org.dto.EmployeDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.exception.InvalidOperationException;
import com.form.org.model.Employe;
import com.form.org.validator.EmployeValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class EmployeServiceImp implements EmployeService {

	private EmployeRepository employeRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public EmployeServiceImp(EmployeRepository employeRepository,
								  PasswordEncoder passwordEncoder) {
		this.employeRepository = employeRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public EmployeDTO save(EmployeDTO dto) {
		List<String> errors = EmployeValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("employe is not valid {}", dto);
			throw new InvalidEntityException("L'employe n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
		}

		if(userAlreadyExists(dto.getEmail())) {
			throw new InvalidEntityException("Un autre employe avec le meme email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
					Collections.singletonList("Un autre employe avec le meme email existe deja dans la BDD"));
		}


		dto.setPassword(passwordEncoder.encode(dto.getPassword()));

		return EmployeDTO.fromEntity(
				employeRepository.save(
						EmployeDTO.toEntity(dto)
				)
		);
	}
	private boolean userAlreadyExists(String email) {
		Optional<Employe> user = employeRepository.findEmployesByEmail(email);
		return user.isPresent();
	}

	@Override
	public EmployeDTO findById(Integer idEmploye) {
		if (idEmploye == null) {
			log.error("employee ID is null");
			return null;
		}
		return employeRepository.findById(idEmploye)
				.map(EmployeDTO::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun employee avec l'ID = " + idEmploye + " n' ete trouve dans la BDD",
						ErrorCodes.UTILISATEUR_NOT_FOUND)
				);
	}

	@Override
	public List<EmployeDTO> findAll() {
		return employeRepository.findAll().stream()
				.map(EmployeDTO::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer idEmploye) {
		if (idEmploye == null) {
			log.error("Employee ID is null");
			return;
		}
		employeRepository.deleteById(idEmploye);
	}

	@Override
	public EmployeDTO findByEmail(String email) {
		return employeRepository.findEmployesByEmail(email)
				.map(EmployeDTO::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun employee avec l'email = " + email + " n' ete trouve dans la BDD",
						ErrorCodes.UTILISATEUR_NOT_FOUND)
				);
	}

	@Override
	public EmployeDTO changerMotDePasse(ChangerMotDePasseUtilisateurDTO dto) {
		return null;
	}
}



