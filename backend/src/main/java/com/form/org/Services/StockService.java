package com.form.org.Services;

import com.form.org.dto.StockDTO;

import java.util.Date;
import java.util.List;

public interface StockService {
    StockDTO save(StockDTO dto);

    StockDTO findById(Integer idStock);

    StockDTO findBydateStock(Date dateStock);

    List<StockDTO> findAll();

    void delete(Integer idStock);
}
