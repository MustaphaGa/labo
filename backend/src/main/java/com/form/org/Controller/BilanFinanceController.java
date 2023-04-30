package com.form.org.Controller;

import com.form.org.Controller.api.BilanFinanceApi;
import com.form.org.Services.BilanFinancierService;
import com.form.org.dto.BilanFinancierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BilanFinanceController implements BilanFinanceApi {

    private BilanFinancierService bilanFinancierService;

    @Autowired
    public BilanFinanceController(BilanFinancierService bilanFinancierService) {
        this.bilanFinancierService = bilanFinancierService;
    }

    @Override
    public BilanFinancierDTO save(BilanFinancierDTO dto) {
        return bilanFinancierService.save(dto);
    }

    @Override
    public BilanFinancierDTO findById(Integer idBilan) {
        return bilanFinancierService.findByIdBilan(idBilan);
    }

    @Override
    public List<BilanFinancierDTO> findAll() {
        return bilanFinancierService.findAll();
    }

    @Override
    public void delecte(Integer idBilan) {
        bilanFinancierService.delete(idBilan);

    }
}
