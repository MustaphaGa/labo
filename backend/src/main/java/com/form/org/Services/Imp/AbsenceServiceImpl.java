package com.form.org.Services.Imp;

import com.form.org.Repository.AbsenceRepository;
import com.form.org.Services.AbsenceService;
import com.form.org.dto.AbsenceDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Absence;
import com.form.org.validator.AbsenceValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AbsenceServiceImpl implements AbsenceService {

    private AbsenceRepository absenceRepository;

    @Autowired
    public AbsenceServiceImpl(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    @Override
    public AbsenceDTO save(AbsenceDTO dto) {
        List<String> errors= AbsenceValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("l'absence n'est pas valide {}",dto);
            throw new InvalidEntityException("l'absence n'est pas valide",
                    ErrorCodes.ABSENCE_NOT_VALID, errors);
        }
        return AbsenceDTO.fromEntity(
                absenceRepository.save(
                        AbsenceDTO.toEntity(dto)));
    }

    @Override
    public AbsenceDTO findById(Integer idAbsence) {
        if(idAbsence == null) {
            log.error("Absence id is null");
            return null;
        }
        Optional<Absence> absence=absenceRepository.findById(idAbsence);

        return Optional.of(AbsenceDTO.fromEntity(absence.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun ABSENCE avec l'ID ="+ idAbsence +"n'été trouve dans la BDD",
                        ErrorCodes.ABSENCE_NOT_FOUND)
        );
    }

    @Override
    public AbsenceDTO findByMotif(String motif) {
        if(motif == null){
            log.error(" absence avec motif null");
            return null;
        }

        Optional<Absence> absence=absenceRepository.findByMotif(motif);

        return Optional.of(AbsenceDTO.fromEntity(absence.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun absence avec cette date ="+ motif +"n'été trouve dans la BDD",
                        ErrorCodes.ABSENCE_NOT_FOUND)
        );
    }

    @Override
    public List<AbsenceDTO> findAll() {
        return absenceRepository.findAll().stream()
                .map(AbsenceDTO :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idAbsence) {
        if(idAbsence == null) {
            log.error("absence id is null");
            return ;
        }

        absenceRepository.deleteById(idAbsence);
    }
}
