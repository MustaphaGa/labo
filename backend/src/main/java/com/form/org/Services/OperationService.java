package com.form.org.Services;

import com.form.org.dto.OperationDTO;

import java.util.Date;
import java.util.List;

public interface OperationService {

    OperationDTO save(OperationDTO dto);

    OperationDTO findById(Integer idOperation);

    OperationDTO findByDateOperation(Date dateOperation);

    List<OperationDTO> findAll();

    void delete(Integer idOperation);
}
