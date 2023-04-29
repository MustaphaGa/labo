package com.form.org.Controller;

import com.form.org.Controller.api.RecrutementApi;
import com.form.org.Services.RecrutementService;
import com.form.org.dto.RecrutementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class RecrutementController implements RecrutementApi {

    private RecrutementService recrutementService;

    @Autowired
    public RecrutementController(RecrutementService recrutementService) {
        this.recrutementService = recrutementService;
    }

    @Override
    public RecrutementDTO save(RecrutementDTO dto) {
        return recrutementService.save(dto);
    }

    @Override
    public RecrutementDTO findByIdRecrutement(Integer idRecrutement) {
        return recrutementService.findByIdRecrutement(idRecrutement);
    }

    @Override
    public RecrutementDTO findByDateRecrutement(Date dateRecrutement) {
        return recrutementService.findByDateRecrutement(dateRecrutement);
    }


    @Override
    public List<RecrutementDTO> findAll() {
        return recrutementService.findAll();
    }

    @Override
    public void delecte(Integer idRecrutement) {
        recrutementService.delete(idRecrutement);

    }
}
