package com.form.org.Services.Imp;

import com.form.org.Repository.MouvementRepository;
import com.form.org.Services.MouvementService;
import com.form.org.dto.MouvementDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Mouvement;
import com.form.org.validator.MouvementValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MouvementServiceImpl implements MouvementService {

    private MouvementRepository mouvementRepository;

    @Autowired
    public MouvementServiceImpl(MouvementRepository mouvementRepository) {
        this.mouvementRepository = mouvementRepository;
    }

    @Override
    public MouvementDTO save(MouvementDTO dto) {
        List<String> errors= MouvementValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("la mouvement n'est pas valide {}",dto);
            throw new InvalidEntityException("la mouvement n'est pas valide",
                    ErrorCodes.MOUVEMENT_NOT_VALID, errors);
        }
        return MouvementDTO.fromEntity(
                mouvementRepository.save(
                        MouvementDTO.toEntity(dto)));
    }


    @Override
    public MouvementDTO findById(Integer idMouvement) {
        if(idMouvement == null) {
            log.error("reservation id is null");
            return null;
        }
        Optional<Mouvement> mouvement=mouvementRepository.findById(idMouvement);

        return Optional.of(MouvementDTO.fromEntity(mouvement.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun mouvement avec l'ID ="+ idMouvement +"n'été trouve dans la BDD",
                        ErrorCodes.MOUVEMENT_NOT_FOUND)
        );
    }

    @Override
    public MouvementDTO findByTypeMouvement(String typeMouvement) {
        return null;
    }

    @Override
    public List<MouvementDTO> findAll() {
        return null;
    }

    @Override
    public void delete(Integer idMouvement) {

    }
}
