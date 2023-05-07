package com.form.org.Controller;

import com.form.org.Controller.api.GestionStockApi;
import com.form.org.Services.GestionStockService;
import com.form.org.dto.GestionStockDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GestionStockController implements GestionStockApi {

    private GestionStockService gestionStockService;

    public GestionStockController(GestionStockService gestionStockService) {
        this.gestionStockService = gestionStockService;
    }

    @Override
    public GestionStockDTO save(GestionStockDTO dto) {
        return gestionStockService.save(dto);
    }

    @Override
    public GestionStockDTO findById(Integer idGesStock) {
        return gestionStockService.findById(idGesStock);
    }

    @Override
    public List<GestionStockDTO> findAll() {
        return gestionStockService.findAll();
    }

    @Override
    public void delete(Integer idGesStock) {
        gestionStockService.delete(idGesStock);

    }
}
