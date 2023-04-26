package com.form.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Mouvement;
import com.form.org.model.RH;
import com.form.org.model.Recrutement;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class RhDTO {

    private Integer idRh;


    @JsonIgnore
    private List<RecrutementDTO> recrutements;

   @JsonIgnore
    private List<MouvementDTO> mouvements;

    public static RhDTO fromEntity(RH rh) {

        if(rh == null) {
            return null;
        }
        return RhDTO.builder()
                .idRh(rh.getIdRh())
                .build();
    }

    public static RH toEntity(RhDTO rhDTO) {
        if(rhDTO == null) {
            return null;
        }
        RH rh = new RH();
        rh.setIdRh(rhDTO.getIdRh());


        return rh;
    }


}
