package com.form.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class RhDTO  {

    private Integer idRh;
    private String nom;

    @JsonIgnore
    private List<RecrutementDTO> recrutements;

   @JsonIgnore
    private List<MouvementDTO> mouvements;

    public static RhDTO fromEntity(RH rh  ) {

        if(rh == null) {
            return null;
        }
        return RhDTO.builder()
                .idRh(rh.getIdRh())
                .nom(rh.getNom())

                .build();
    }

    public static RH toEntity(RhDTO rhDTO) {
        if(rhDTO == null) {
            return null;
        }
        RH rh = new RH();
        rh.setIdRh(rhDTO.getIdRh());
        rh.setNom(rhDTO.getNom());



        return rh;
    }


}
