package com.form.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.BilanFinancier;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Builder
@Data
public class BilanFinancierDTO {
    private Integer idBilan;
    private String Annee_BF;
    private Double Montant_BF;
    private CompteDTO compte;

    @JsonIgnore
    private List<OperationDTO> operations;

    public static BilanFinancierDTO fromEntity(BilanFinancier bilanFinancier) {
        if(bilanFinancier == null) {
            return null;
        }
        return   BilanFinancierDTO.builder()
                .idBilan(bilanFinancier.getIdBilan())
                .Annee_BF(bilanFinancier.getAnnee_BF())
                .Montant_BF(bilanFinancier.getMontant_BF())
                .compte(CompteDTO.fromEntity(bilanFinancier.getCompte()))
                .build();
    }


    public static BilanFinancier toEntity(BilanFinancierDTO bilanFinancierDTO) {

        if(bilanFinancierDTO== null) {
            return null;

        }
        BilanFinancier bilanFinancier = new BilanFinancier();

        bilanFinancier.setIdBilan(bilanFinancierDTO.getIdBilan());
        bilanFinancier.setAnnee_BF(bilanFinancierDTO.getAnnee_BF());
        bilanFinancier.setMontant_BF(bilanFinancierDTO.getMontant_BF());
        bilanFinancier.setCompte(CompteDTO.toEntity(bilanFinancierDTO.getCompte()));


        return bilanFinancier;
    }

}
