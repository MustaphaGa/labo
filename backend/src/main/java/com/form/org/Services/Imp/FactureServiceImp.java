package com.form.org.Services.Imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.form.org.Repository.FactureRepository;
import com.form.org.Services.FactureService;
import com.form.org.dto.FactureDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Facture;
import com.form.org.validator.FactureValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class FactureServiceImp implements FactureService {
	
	private FactureRepository factureRepository;
	
	
	@Autowired
	public FactureServiceImp(FactureRepository factureRepository) {
		this.factureRepository=factureRepository;
		
	}

	@Override
	public FactureDTO save(FactureDTO dto) {
		
		List<String> errors= FactureValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("la facture n'est pas valide {}",dto);
			throw new InvalidEntityException("la facture n'est pas valide", ErrorCodes.FACTURE_NOT_VALID, errors);
		}
		return FactureDTO.fromEntity(
				factureRepository.save(
			   FactureDTO.toEntity(dto)	
						)
				);
	}

	@Override
	public FactureDTO findById(Integer idFacture) {
		if(idFacture == null) {	
			log.error("facture id is null");
			return null;
		}
		Optional<Facture> facture=factureRepository.findById(idFacture);
		
		return Optional.of(FactureDTO.fromEntity(facture.get())).orElseThrow(() ->
		       new EntityNotFoundException(
				"Aucun facture avec l'ID ="+ idFacture +"n'été trouve dans la BDD",
				ErrorCodes.FACTURE_NOT_FOUND)
		);
	}
	

	@Override
	public List<FactureDTO> findAll() {
		return factureRepository.findAll().stream()
				.map(FactureDTO :: fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer idFacture) {
		if(idFacture == null) {	
			log.error("facture id is null");
			return ;
		}
		
		factureRepository.deleteById(idFacture);
		
	}

}
