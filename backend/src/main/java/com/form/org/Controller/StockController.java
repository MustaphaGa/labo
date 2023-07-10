package com.form.org.Controller;

import com.form.org.Controller.api.StockApi;
import com.form.org.Services.StockService;
import com.form.org.dto.StockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
public class StockController implements StockApi {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public StockDTO save(StockDTO dto) {
        return stockService.save(dto);
    }

    @Override
    public StockDTO findById(Integer idStock) {
        return stockService.findById(idStock);
    }

    @Override
    public StockDTO findBydateStock(Date dateStock) {
        return stockService.findBydateStock(dateStock);
    }

    @Override
    public List<StockDTO> findAll() {
        return stockService.findAll();
    }

    @Override
    public BigDecimal calculateStock(Integer idArticle) {
        return stockService.calculateStock(idArticle);
    }


    @Override
    public void delete(Integer idStock) {
        stockService.delete(idStock);

    }
}
