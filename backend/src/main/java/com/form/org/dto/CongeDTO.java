package com.form.org.dto;


import com.form.org.model.Conge;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CongeDTO {

    private Integer idConge;
    private Date dateDebut;
    private Date dateFin;

    private EmployeDTO employe;

    public static CongeDTO fromEntity(Conge conge) {

        if(conge == null) {
            return null;
        }
        return CongeDTO.builder()
                .idConge(conge.getIdConge())
                .dateDebut(conge.getDateDebut())
                .dateFin(conge.getDateFin())
                .employe(EmployeDTO.fromEntity(conge.getEmploye()))
                .build();
    }

    public static Conge toEntity(CongeDTO congeDTO) {
        if(congeDTO == null) {
            return null;
        }
        Conge conge = new Conge();
        conge.setIdConge(congeDTO.getIdConge());
        conge.setDateDebut(congeDTO.getDateDebut());
        conge.setDateFin(congeDTO.getDateFin());

        conge.setEmploye(EmployeDTO.toEntity(congeDTO.getEmploye()));

        return conge;
    }

}
