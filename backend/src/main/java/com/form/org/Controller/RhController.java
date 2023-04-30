package com.form.org.Controller;

import com.form.org.Controller.api.RhApi;
import com.form.org.Services.RhService;
import com.form.org.dto.RhDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RhController implements RhApi {

    private RhService rhService;

    @Autowired
    public RhController(RhService rhService) {
                this.rhService = rhService;
    }

    @Override
    public RhDTO save(RhDTO dto) {
        return rhService.save(dto);
    }

    @Override
    public RhDTO findById(Integer idRh) {
        return rhService.findById(idRh);
    }

    @Override
    public List<RhDTO> findAll() {
        return rhService.findAll();
    }

    @Override
    public void delecte(Integer idRh) {
        rhService.delete(idRh);

    }
}
