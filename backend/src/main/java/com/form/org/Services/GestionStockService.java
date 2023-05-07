package com.form.org.Services;

import com.form.org.dto.GestionStockDTO;

import java.util.List;

public interface GestionStockService {
    GestionStockDTO save(GestionStockDTO dto);

    GestionStockDTO findById(Integer idGesStock);


    List<GestionStockDTO> findAll();

    void delete(Integer idGesStock);
}
