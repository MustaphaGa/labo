package com.form.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.NatureOperation;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class NatureOperationDTO {

    private Integer idNatureOperation;
    private String libNatureOperation;

    @JsonIgnore
    private List<OperationDTO> operations;


    public static NatureOperationDTO fromEntity(NatureOperation natureOperation) {
        if (natureOperation == null)
        {
            return null;
        }
        return NatureOperationDTO.builder()
                .idNatureOperation(natureOperation.getIdNatureOperation())
                .libNatureOperation(natureOperation.getLibNatureOperation())
                .build();
    }

    @SuppressWarnings("unused")
    public static NatureOperation toEntity(NatureOperationDTO natureOperationDTO) {
        if(natureOperationDTO == null) {
            return null;
        }

        NatureOperation natureOperation=new NatureOperation();
        natureOperation.setIdNatureOperation(natureOperationDTO.getIdNatureOperation());
        natureOperation.setLibNatureOperation(natureOperationDTO.getLibNatureOperation());

        return natureOperation;

    }
}
