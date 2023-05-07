package com.form.org.Controller;

import com.form.org.Controller.api.BonCommandeApi;
import com.form.org.Services.BonCommandeService;
import com.form.org.dto.BonCommandeDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BonCommandeController implements BonCommandeApi {

    private BonCommandeService bonCommandeService;

    public BonCommandeController(BonCommandeService bonCommandeService) {
        this.bonCommandeService = bonCommandeService;
    }

    @Override
    public BonCommandeDTO save(BonCommandeDTO dto) {
        return bonCommandeService.save(dto);
    }

    @Override
    public BonCommandeDTO findById(Integer idBonCommande) {
        return bonCommandeService.findById(idBonCommande);
    }

    @Override
    public BonCommandeDTO findByDateAnalyse(Date dateCommande) {
        return bonCommandeService.findByDateCommande(dateCommande);
    }

    @Override
    public List<BonCommandeDTO> findAll() {
        return bonCommandeService.findAll();
    }

    @Override
    public void delecte(Integer idBonCommande) {
        bonCommandeService.delete(idBonCommande);

    }
}
