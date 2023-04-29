package com.form.org.Controller;

import com.form.org.Controller.api.MouvementApi;
import com.form.org.Services.MouvementService;
import com.form.org.dto.MouvementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MouvementController implements MouvementApi {
    private MouvementService mouvementService;

    @Autowired
    public MouvementController(MouvementService mouvementService) {
        this.mouvementService = mouvementService;
    }

    @Override
    public MouvementDTO save(MouvementDTO dto) {
        return mouvementService.save(dto);
    }

    @Override
    public MouvementDTO findById(Integer idMouvement) {
        return mouvementService.findById(idMouvement);
    }

    @Override
    public MouvementDTO findPatientByCodePatient(String typeMouvement) {
        return mouvementService.findByTypeMouvement(typeMouvement);
    }

    @Override
    public List<MouvementDTO> findAll() {
        return mouvementService.findAll();
    }

    @Override
    public void delecte(Integer idMouvement) {
        mouvementService.delete(idMouvement);

    }
}
