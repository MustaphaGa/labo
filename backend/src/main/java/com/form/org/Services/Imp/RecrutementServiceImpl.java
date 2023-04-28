package com.form.org.Services.Imp;

import com.form.org.Repository.RecrutementRepository;
import com.form.org.Repository.ReservationRepository;
import com.form.org.Services.RecrutementService;
import com.form.org.dto.RecrutementDTO;
import com.form.org.dto.ReservationDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Recrutement;
import com.form.org.model.Reservation;
import com.form.org.validator.RecrutementValidator;
import com.form.org.validator.ReservationValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RecrutementServiceImpl implements RecrutementService {



     private RecrutementRepository recrutementRepository;

    @Autowired
    public RecrutementServiceImpl(RecrutementRepository recrutementRepository) {
        this.recrutementRepository = recrutementRepository;
    }

    @Override
    public RecrutementDTO save(RecrutementDTO dto) {
        List<String> errors= RecrutementValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("la recrutement n'est pas valide {}",dto);
            throw new InvalidEntityException("la recrutement n'est pas valide",
                    ErrorCodes.RESERVATION_NOT_VALID, errors);
        }
        return RecrutementDTO.fromEntity(
                recrutementRepository.save(
                        RecrutementDTO.toEntity(dto)));
    }

    @Override
    public RecrutementDTO findByIdRecrutement(Integer idRecrutement) {
        if(idRecrutement == null) {
            log.error("reservation id is null");
            return null;
        }
        Optional<Recrutement> recrutement=recrutementRepository.findById(idRecrutement);

        return Optional.of(RecrutementDTO.fromEntity(recrutement.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun recrutement avec l'ID ="+ idRecrutement +"n'été trouve dans la BDD",
                        ErrorCodes.RESERVATION_NOT_FOUND)
        );
    }

    @Override
    public RecrutementDTO findByDateRecrutement(Date dateRecrutement) {
        if(dateRecrutement == null){
            log.error(" date de reservation null");
            return null;
        }

        Optional<Recrutement> recrutement=recrutementRepository.findByDateRecrutement(dateRecrutement);

        return Optional.of(RecrutementDTO.fromEntity(recrutement.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun recrutement avec cette date ="+ dateRecrutement +"n'été trouve dans la BDD",
                        ErrorCodes.RESERVATION_NOT_FOUND)
        );
    }

    @Override
    public List<RecrutementDTO> findAll() {
        return recrutementRepository.findAll().stream()
                .map(RecrutementDTO :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idRecrutement) {
        if(idRecrutement == null) {
            log.error("reservation id is null");
            return ;
        }

        recrutementRepository.deleteById(idRecrutement);

    }
}
