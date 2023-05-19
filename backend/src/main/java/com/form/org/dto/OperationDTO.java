package com.form.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.AnalyseMedical;
import com.form.org.model.Operation;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class OperationDTO {

    private Integer idOperation;
    private Date dateOperation;
    private String typeOperation;


    private EmployeDTO employe;
    private BilanFinancierDTO bilanFinancier;
    @JsonIgnore
    private List<FactureDTO> factures;

    public static OperationDTO fromEntity(Operation operation) {
        if(operation == null) {
            return null;
        }
        return   OperationDTO.builder()
                .idOperation(operation.getIdOperation())
                .dateOperation(operation.getDateOperation())
                .typeOperation(operation.getTypeOperation())
                .bilanFinancier(BilanFinancierDTO.fromEntity(operation.getBilanFinancier()))
                .employe(EmployeDTO.fromEntity((operation.getEmploye())))
                .build();
    }


    public static Operation toEntity(OperationDTO operationDTO) {

        if(operationDTO== null) {
            return null;

        }
        Operation operation = new Operation();


        operation.setIdOperation(operationDTO.getIdOperation());
        operation.setDateOperation(operationDTO.getDateOperation());
        operation.setTypeOperation(operationDTO.getTypeOperation());
        operation.setBilanFinancier((BilanFinancierDTO.toEntity(operationDTO.getBilanFinancier())));
        operation.setEmploye(EmployeDTO.toEntity((operationDTO.getEmploye())));
        return operation;
    }




}
