package com.form.org.Services;

import com.form.org.dto.StockDTO;
import com.form.org.model.Stock;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StockService {
    StockDTO save(StockDTO dto);

    StockDTO findById(Integer idStock);
    BigDecimal calculateStock(Integer idArticle);
    StockDTO findBydateStock(Date dateStock);

    List<StockDTO> findAll();

    void delete(Integer idStock);
}
