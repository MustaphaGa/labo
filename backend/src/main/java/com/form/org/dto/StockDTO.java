package com.form.org.dto;


import com.form.org.model.Stock;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class StockDTO {

    private Integer idStock;
    private String situation;
    private Date dateVerification;




    public static StockDTO fromEntity(Stock stock) {
        if(stock == null) {
            return null;
        }
        return   StockDTO.builder()
                .idStock(stock.getIdStock())
                .situation(stock.getSituation())
                .dateVerification(stock.getDateVerification())

                .build();
    }


    public static Stock toEntity(StockDTO stockDTO) {

        if(stockDTO== null) {
            return null;

        }
        Stock stock= new Stock();

        stock.setIdStock(stockDTO.getIdStock());
        stock.setSituation(stockDTO.getSituation());
        stock.setDateVerification(stockDTO.getDateVerification());



        return stock;
    }

}
