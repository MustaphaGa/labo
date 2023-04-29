package com.form.org.Controller;

import com.form.org.Controller.api.CongeApi;
import com.form.org.Services.CongeService;
import com.form.org.dto.CongeDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

@RestController
public class CongeController implements CongeApi {

    private CongeService congeService;

    public CongeController(CongeService congeService) {
        this.congeService = congeService;
    }

    @Override
    public CongeDTO save(CongeDTO dto) {
        return congeService.save(dto);
    }

    @Override
    public CongeDTO findById(Integer idConge) {
        return congeService.findById(idConge);
    }

    @Override
    public List<CongeDTO> findAll() {
        return congeService.findAll();
    }

    @Override
    public void delecte(Integer idConge) {
        congeService.delete(idConge);

    }
}
