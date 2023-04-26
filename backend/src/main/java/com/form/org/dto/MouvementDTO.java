package com.form.org.dto;

import com.form.org.model.Conge;
import com.form.org.model.Mouvement;
import com.form.org.model.RH;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MouvementDTO {

    private Integer idMouvement;
    private String typeMouvement;
    private String detailMouvement;
    private double frais;

    private RhDTO rh;

    public static MouvementDTO fromEntity(Mouvement mouvement) {

        if(mouvement == null) {
            return null;
        }
        return MouvementDTO.builder()
                .idMouvement(mouvement.getIdMouvement())
                .typeMouvement(mouvement.getTypeMouvement())
                .detailMouvement(mouvement.getDetailMouvement())
                .frais(mouvement.getFrais())
                .rh(RhDTO.fromEntity(mouvement.getRh()))
                .build();
    }

        public static Mouvement toEntity(MouvementDTO mouvementDTO) {
        if(mouvementDTO == null) {
            return null;
        }
        Mouvement mouvement = new Mouvement();
            mouvement.setIdMouvement(mouvementDTO.getIdMouvement());
            mouvement.setTypeMouvement(mouvementDTO.getTypeMouvement());
            mouvement.setDetailMouvement(mouvementDTO.getDetailMouvement());
            mouvement.setFrais(mouvementDTO.getFrais());

            mouvement.setRh(RhDTO.toEntity(mouvementDTO.getRh()));

        return mouvement;
    }


}
