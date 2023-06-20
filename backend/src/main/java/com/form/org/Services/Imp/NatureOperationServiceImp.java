package com.form.org.Services.Imp;

import com.form.org.Repository.NatureOperationRepository;
import com.form.org.Services.NatureOperationService;
import com.form.org.dto.NatureOperationDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.NatureOperation;
import com.form.org.validator.NatureOperationValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NatureOperationServiceImp implements NatureOperationService {

    private NatureOperationRepository natureOperationRepository;

    @Autowired
    public NatureOperationServiceImp(NatureOperationRepository natureOperationRepository){
        this.natureOperationRepository = natureOperationRepository;
    }

    @Override
    public NatureOperationDTO save(NatureOperationDTO dto) {
        List<String> errors= NatureOperationValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("la nature d'operation n'est pas valide {}",dto);
            throw new InvalidEntityException("la nature d'operation n'est pas valide", ErrorCodes.NATUREOPERATION_NOT_VALID, errors);
        }
        return NatureOperationDTO.fromEntity(
                natureOperationRepository.save(
                        NatureOperationDTO.toEntity(dto)
                )
        );
    }

    @Override
    public NatureOperationDTO findById(Integer idNatureOperation) {
        if(idNatureOperation == null) {
            log.error("patient id is null");
            return null;
        }
        Optional<NatureOperation> natureOperation=natureOperationRepository.findById(idNatureOperation);

        return Optional.of(NatureOperationDTO.fromEntity(natureOperation.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun nature d'operation avec l'ID ="+ idNatureOperation +"n'été trouve dans la BDD",
                        ErrorCodes.NATUREOPERATION_NOT_FOUND)
        );
    }



    @Override
    public List<NatureOperationDTO> findAll() {
        return natureOperationRepository.findAll().stream()
                .map(NatureOperationDTO :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idNatureOperation) {
        if(idNatureOperation == null) {
            log.error(" nature d'operation est  null");
            return ;
        }
        natureOperationRepository.deleteById(idNatureOperation);

    }

}
