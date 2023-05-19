package com.form.org.dto;

import com.form.org.model.Recrutement;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RecrutementDTO {
    private Integer idRecrutement;
    private Date dateRecrutement;
    private String typeRecrutement;


    private EmployeDTO employe;


    public static RecrutementDTO fromEntity(Recrutement recrutement) {

        if(recrutement == null) {
            return null;
        }
        return RecrutementDTO.builder()
                .idRecrutement(recrutement.getIdRecrutement())
                .dateRecrutement(recrutement.getDateRecrutement())
                .typeRecrutement(recrutement.getTypeRecrutement())
                .employe(EmployeDTO.fromEntity(recrutement.getEmploye()))
                .build();
    }

    public static Recrutement toEntity(RecrutementDTO recrutementDTO) {
        if(recrutementDTO == null) {
            return null;
        }
        Recrutement recrutement = new Recrutement();
        recrutement.setIdRecrutement(recrutementDTO.getIdRecrutement());
        recrutement.setTypeRecrutement(recrutementDTO.getTypeRecrutement());
        recrutement.setDateRecrutement(recrutementDTO.getDateRecrutement());
        recrutement.setEmploye(EmployeDTO.toEntity(recrutementDTO.getEmploye()));


        return recrutement;
    }

}
