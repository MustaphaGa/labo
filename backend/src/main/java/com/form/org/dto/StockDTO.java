package com.form.org.dto;


import com.form.org.model.Stock;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class StockDTO {


    private Integer idStock;
    private String QuatiteStock;
    private Date dateStock;

    private ArticleDTO article;


    public static StockDTO fromEntity(Stock stock) {
        if(stock == null) {
            return null;
        }
        return   StockDTO.builder()
                .idStock(stock.getIdStock())
                .QuatiteStock(stock.getQuatiteStock())
                .dateStock(stock.getDateStock())
                .article(ArticleDTO.fromEntity(stock.getArticle()))

                .build();
    }


    public static Stock toEntity(StockDTO stockDTO) {

        if(stockDTO== null) {
            return null;

        }
        Stock stock= new Stock();

        stock.setIdStock(stockDTO.getIdStock());
        stock.setQuatiteStock(stockDTO.getQuatiteStock());
        stock.setDateStock(stockDTO.getDateStock());

        return stock;
    }

}
