package com.form.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.BilanFinancier;
import com.form.org.model.Operation;
import com.form.org.model.ServiceFinance;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class ServiceFinanceDTO {
    private Integer idFinance;

   @JsonIgnore
    private List<OperationDTO> operations;

    public static ServiceFinanceDTO fromEntity(ServiceFinance serviceFinance) {
        if(serviceFinance == null) {
            return null;
        }
        return   ServiceFinanceDTO.builder()
                .idFinance(serviceFinance.getIdFinance())

                .build();
    }


    public static ServiceFinance toEntity(ServiceFinanceDTO serviceFinanceDTO) {

        if(serviceFinanceDTO== null) {
            return null;

        }
        ServiceFinance serviceFinance = new ServiceFinance();

        serviceFinance.setIdFinance(serviceFinanceDTO.getIdFinance());

        return serviceFinance;
    }
}
