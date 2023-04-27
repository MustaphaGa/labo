package com.form.org.Services.Imp;

import com.form.org.Repository.CongeRepository;
import com.form.org.Services.CongeService;
import com.form.org.dto.CongeDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Conge;
import com.form.org.validator.CongeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CongeServiceImpl implements CongeService {

    private CongeRepository congeRepository;

    @Autowired
    public CongeServiceImpl(CongeRepository congeRepository) {
        this.congeRepository = congeRepository;
    }

    @Override
    public CongeDTO save(CongeDTO dto) {
        List<String> errors= CongeValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error(" Conge n'est pas valide {}",dto);
            throw new InvalidEntityException("Conge n'est pas valide",
                    ErrorCodes.CONGE_NOT_VALID, errors);
        }
        return CongeDTO.fromEntity(
                congeRepository.save(
                        CongeDTO.toEntity(dto)));
    }

    @Override
    public CongeDTO findById(Integer idConge) {
        if(idConge == null) {
            log.error("Conge id is null");
            return null;
        }
        Optional<Conge> conge=congeRepository.findById(idConge);

        return Optional.of(CongeDTO.fromEntity(conge.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun Conge avec l'ID ="+ idConge +"n'été trouve dans la BDD",
                        ErrorCodes.CONGE_NOT_FOUND)
        );
    }

    @Override
    public List<CongeDTO> findAll() {

        return congeRepository.findAll().stream()
                .map(CongeDTO:: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idConge) {
        if(idConge == null) {
        log.error("reservation id is null");
        return ;
    }

        congeRepository.deleteById(idConge);


    }
}
