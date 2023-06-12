package com.form.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer Annee;
    private String description;
    private Float Montant;



    private CompteDTO compte;
   // private EmployeDTO employe;
    //private BilanFinancierDTO bilanFinancier;
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
                .Annee(operation.getAnnee())
                .description(operation.getDescription())
                .Montant(operation.getMontant())
                .compte(CompteDTO.fromEntity(operation.getCompte()))

               // .bilanFinancier(BilanFinancierDTO.fromEntity(operation.getBilanFinancier()))
                //.employe(EmployeDTO.fromEntity((operation.getEmploye())))
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
        operation.setAnnee(operationDTO.getAnnee());
        operation.setDescription(operationDTO.getDescription());
        operation.setMontant(operationDTO.getMontant());
        operation.setCompte(CompteDTO.toEntity(operationDTO.getCompte()));
        //operation.setBilanFinancier((BilanFinancierDTO.toEntity(operationDTO.getBilanFinancier())));
        //operation.setEmploye(EmployeDTO.toEntity((operationDTO.getEmploye())));
        return operation;
    }




}
