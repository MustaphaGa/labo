package com.form.org.Services.Imp;

import com.form.org.Repository.OperationRepository;
import com.form.org.Services.OperationService;
import com.form.org.dto.OperationDTO;
import com.form.org.dto.PatientDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Operation;
import com.form.org.validator.OperationValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OperationServiceImpl implements OperationService {

    private OperationRepository operationRepository;

    @Autowired
    public OperationServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public OperationDTO save(OperationDTO dto) {
        List<String> errors= OperationValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("l'operation n'est pas valide {}",dto);
            throw new InvalidEntityException("l'absence n'est pas valide",
                    ErrorCodes.OPERATION_NOT_VALID, errors);
        }
        return OperationDTO.fromEntity(
                operationRepository.save(
                        OperationDTO.toEntity(dto)));
    }

    @Override
    public OperationDTO findById(Integer idOperation) {
        if(idOperation == null) {
            log.error("operation id is null");
            return null;
        }
        Optional<Operation> operation=operationRepository.findById(idOperation);

        return Optional.of(OperationDTO.fromEntity(operation.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun operation avec l'ID ="+ idOperation +"n'été trouve dans la BDD",
                        ErrorCodes.OPERATION_NOT_FOUND)
        );
    }

    @Override
    public OperationDTO findByDateOperation(Date dateOperation) {
        if(dateOperation == null){
            log.error("operation Code is null");
            return null;
        }

        Optional<Operation> operation=operationRepository.findByDateOperation(dateOperation);

        return Optional.of(OperationDTO.fromEntity(operation.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun operation avec le Code operation ="+ dateOperation +"n'été trouve dans la BDD",
                        ErrorCodes.OPERATION_NOT_FOUND)
        );
    }

    @Override
    public List<OperationDTO> findAll() {
        return operationRepository.findAll().stream()
                .map(OperationDTO:: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idOperation) {
        if(idOperation == null) {
            log.error("operation id is null");
            return ;
        }
        operationRepository.deleteById(idOperation);

    }
}
