package com.form.org.dto;

import com.form.org.model.Mouvement;
import com.form.org.model.RH;
import com.form.org.model.Recrutement;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Builder
public class RecrutementDTO {
    private Integer idRecrutement;
    private Date dateRecrutement;
    private String typeRecrutement;


    private RhDTO rh;


    public static RecrutementDTO fromEntity(Recrutement recrutement) {

        if(recrutement == null) {
            return null;
        }
        return RecrutementDTO.builder()
                .idRecrutement(recrutement.getIdRecrutement())
                .dateRecrutement(recrutement.getDateRecrutement())
                .typeRecrutement(recrutement.getTypeRecrutement())
                .rh(RhDTO.fromEntity(recrutement.getRh()))
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

        recrutement.setRh(RhDTO.toEntity(recrutementDTO.getRh()));

        return recrutement;
    }

}
