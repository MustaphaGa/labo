package com.form.org.Services.Imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.form.org.Repository.DetailResultatRepository;
import com.form.org.Services.DetailResultatService;
import com.form.org.dto.DetailResultatDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.DetailResultat;
import com.form.org.validator.DetailResultatValidator;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j 
public class DetailResultatServiceImp implements DetailResultatService{
 private DetailResultatRepository detailResultatRepository;
 
 
 @Autowired
 public DetailResultatServiceImp(DetailResultatRepository detailResultatRepository) {
	 this.detailResultatRepository=detailResultatRepository;
 }
	

	@Override
	public DetailResultatDTO save(DetailResultatDTO dto) {
		List<String> errors= DetailResultatValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("le detail Resultat n'est pas valide {}",dto);
			throw new InvalidEntityException("la patient n'est pas valide", ErrorCodes.DETAIL_RESULTAT_NOT_VALID, errors);
		}
		return DetailResultatDTO.fromEntity(
				detailResultatRepository.save(
				DetailResultatDTO.toEntity(dto)	
						)
				);
	}

	@Override
	public DetailResultatDTO findById(Integer idDetailResultat) {
		
		if(idDetailResultat == null) {	
			log.error("detail Resultat id is null");
			return null;
		}
		Optional<DetailResultat> detailResultat=detailResultatRepository.findById(idDetailResultat);
		
		return Optional.of(DetailResultatDTO.fromEntity(detailResultat.get())).orElseThrow(() ->
		       new EntityNotFoundException(
				"Aucun detail resultat avec l'ID ="+ idDetailResultat +"n'été trouve dans la BDD",
				ErrorCodes.DETAIL_RESULTAT_NOT_FOUND)
		);
	}

	@Override
	public List<DetailResultatDTO> findAll() {
			return detailResultatRepository.findAll().stream()
					.map(DetailResultatDTO :: fromEntity)
					.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer idDetailResultat) {
		if(idDetailResultat == null) {	
			log.error("detail Result id is null");
			return ;
		}
		
		detailResultatRepository.deleteById(idDetailResultat);
		
	}

}
