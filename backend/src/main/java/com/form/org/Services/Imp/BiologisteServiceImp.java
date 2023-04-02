package com.form.org.Services.Imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.form.org.Repository.BiologisteRepository;
import com.form.org.Services.BiologisteService;
import com.form.org.dto.BiologisteDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Biologiste;
import com.form.org.validator.BiologisteValidator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BiologisteServiceImp implements BiologisteService {

	private BiologisteRepository biologisteRepository;

	@Autowired
	public BiologisteServiceImp(BiologisteRepository biologisteRepository) {
		this.biologisteRepository = biologisteRepository;
	}

	@Override
	public BiologisteDTO save(BiologisteDTO dto) {
		List<String> errors = BiologisteValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("la biologiste n'est pas valide {}", dto);
			throw new InvalidEntityException("la biologiste n'est pas valide", ErrorCodes.BIOLOGISTE_NOT_VALID, errors);
		}
		return BiologisteDTO.fromEntity(biologisteRepository.save(BiologisteDTO.toEntity(dto)));
	}

	@Override
	public BiologisteDTO findById(Integer id) {
		if (id == null) {
			log.error("biologiste id is null");
			return null;
		}
		Optional<Biologiste> biologiste = biologisteRepository.findById(id);

		return Optional.of(BiologisteDTO.fromEntity(biologiste.get()))
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun biologiste avec l'ID =" + id + "n'été trouve dans la BDD",
						ErrorCodes.BIOLOGISTE_NOT_FOUND));
	}

	@Override
	public BiologisteDTO findBiologisteByCode(String codeBiologiste) {

		if (!StringUtils.hasLength(codeBiologiste)) {
			log.error("biologiste Code is null");
			return null;
		}

		Optional<Biologiste> biologiste = biologisteRepository.findBiologisteByCodeBiologiste(codeBiologiste);
		return Optional.of(BiologisteDTO.fromEntity(biologiste.get()))
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun biologiste avec le Code  =" + codeBiologiste + "n'été trouve dans la BDD",
						ErrorCodes.BIOLOGISTE_NOT_FOUND));
	}

	@Override
	public List<BiologisteDTO> findAll() {
		return biologisteRepository.findAll().stream().map(BiologisteDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("biologiste id is null");
			return;
		}
		biologisteRepository.deleteById(id);

	}

}
