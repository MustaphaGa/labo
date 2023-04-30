package com.form.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.BilanFinancier;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BilanFinancierDTO {
    private Integer idBilan;
    private String description;

    @JsonIgnore
    private List<OperationDTO> operations;

    public static BilanFinancierDTO fromEntity(BilanFinancier bilanFinancier) {
        if(bilanFinancier == null) {
            return null;
        }
        return   BilanFinancierDTO.builder()
                .idBilan(bilanFinancier.getIdBilan())
                .description(bilanFinancier.getDescription())
                .build();
    }


    public static BilanFinancier toEntity(BilanFinancierDTO bilanFinancierDTO) {

        if(bilanFinancierDTO== null) {
            return null;

        }
        BilanFinancier bilanFinancier = new BilanFinancier();

        bilanFinancier.setIdBilan(bilanFinancierDTO.getIdBilan());
        bilanFinancier.setDescription(bilanFinancierDTO.getDescription());

        return bilanFinancier;
    }

}
