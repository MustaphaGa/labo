package com.form.org.Controller;

import com.form.org.Controller.api.CompteApi;
import com.form.org.Services.CompteService;
import com.form.org.dto.CompteDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CompteController implements CompteApi {

    private CompteService compteService;

    public  CompteController(CompteService compteService)
    {
        this.compteService=compteService;
    }

    @Override
    public CompteDTO save(CompteDTO dto) {
        return compteService.save(dto);
    }

    @Override
    public CompteDTO findById(Integer idCompte) {

        return compteService.findById(idCompte);
    }

    @Override
    public List<CompteDTO> findAll() {
        return compteService.findAll();
    }

    @Override
    public void delete(Integer idCompte) {
        compteService.delete(idCompte);
    }
}
