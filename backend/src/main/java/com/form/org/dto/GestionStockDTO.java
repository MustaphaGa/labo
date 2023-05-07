package com.form.org.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.GestionStock;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GestionStockDTO {


    private Integer idGesStock;


    @JsonIgnore
    private List<BonCommandeDTO> bonCommandes;


    private StockDTO stock;



    public static GestionStockDTO fromEntity(GestionStock gestionStock) {
        if(gestionStock == null) {
            return null;
        }
        return   GestionStockDTO.builder()
                .idGesStock(gestionStock.getIdGesStock())
                .stock(StockDTO.fromEntity(gestionStock.getStock()))
                .build();
    }


    public static GestionStock toEntity(GestionStockDTO gestionStockDTO) {

        if(gestionStockDTO== null) {
            return null;

        }
        GestionStock gestionStock= new GestionStock();

        gestionStock.setIdGesStock(gestionStockDTO.getIdGesStock());
        gestionStock.setStock(StockDTO.toEntity(gestionStockDTO.getStock()));

        return gestionStock;
    }
}
