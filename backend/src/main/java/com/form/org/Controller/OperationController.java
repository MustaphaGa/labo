package com.form.org.Controller;

import com.form.org.Controller.api.OperationApi;
import com.form.org.Services.OperationService;
import com.form.org.dto.OperationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class OperationController implements OperationApi {
    private OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @Override
    public OperationDTO save(OperationDTO dto) {
        return operationService.save(dto);
    }

    @Override
    public OperationDTO findById(Integer idOperation) {
        return operationService.findById(idOperation);
    }

    @Override
    public OperationDTO findByDateOperation(Date dateOperation) {
        return operationService.findByDateOperation(dateOperation);
    }

    @Override
    public List<OperationDTO> findAll() {
        return operationService.findAll();
    }

    @Override
    public void delecte(Integer idOperation) {
        operationService.delete(idOperation);

    }
}
