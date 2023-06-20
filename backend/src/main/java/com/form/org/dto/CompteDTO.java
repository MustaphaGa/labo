package com.form.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Compte;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class CompteDTO {
    private Integer idCompte;
    private String libCompte;
    private  String NumeroCompte;

    @JsonIgnore
    private List<OperationDTO> Operations;

    @JsonIgnore
    private List<BilanFinancierDTO> BilanFinanciers;

    public static CompteDTO fromEntity(Compte compte) {
        if(compte == null) {
            return null;
        }
        return   CompteDTO.builder()
                .idCompte(compte.getIdCompte())
               .libCompte(compte.getLibCompte())
                .NumeroCompte(compte.getNumeroCompte())
                .build();
}

    public static Compte toEntity(CompteDTO compteDTO) {

        if(compteDTO== null) {
            return null;

        }
        Compte compte = new Compte();
        compte.setIdCompte(compteDTO.getIdCompte());
        compte.setLibCompte(compteDTO.getLibCompte());
        compte.setNumeroCompte(compteDTO.getNumeroCompte());
        return compte;
    }
}
