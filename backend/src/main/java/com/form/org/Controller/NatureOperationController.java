package com.form.org.Controller;

import com.form.org.Controller.api.NatureOperationApi;
import com.form.org.Services.NatureOperationService;
import com.form.org.dto.NatureOperationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class NatureOperationController implements NatureOperationApi {
    private NatureOperationService natureOperationService;

    @Autowired
    public NatureOperationController(NatureOperationService natureOperationService){
        this.natureOperationService= natureOperationService;
    }

    @Override
    public NatureOperationDTO save(NatureOperationDTO dto) {
        return natureOperationService.save(dto);
    }

    @Override
    public NatureOperationDTO findById(Integer idNatureOperation) {
        return natureOperationService.findById(idNatureOperation);
    }

    @Override
    public List<NatureOperationDTO> findAll() {
        return natureOperationService.findAll();
    }

    @Override
    public void delecte(Integer idNatureOperation) {
         natureOperationService.delete(idNatureOperation);

    }
}
