package com.form.org.Controller;

import com.form.org.Controller.api.ServiceFinanceApi;
import com.form.org.Services.ServiceFinanceService;
import com.form.org.dto.ServiceFinanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceFinanceController implements ServiceFinanceApi {

    private ServiceFinanceService serviceFinanceService;

    @Autowired
    public ServiceFinanceController(ServiceFinanceService serviceFinanceService) {
        this.serviceFinanceService = serviceFinanceService;
    }

    @Override
    public ServiceFinanceDTO save(ServiceFinanceDTO dto) {
        return serviceFinanceService.save(dto);
    }

    @Override
    public ServiceFinanceDTO findById(Integer idFinance) {
        return serviceFinanceService.findByidFinance(idFinance);
    }

    @Override
    public List<ServiceFinanceDTO> findAll() {
        return serviceFinanceService.findAll();
    }

    @Override
    public void delecte(Integer idFinance) {
        serviceFinanceService.delete(idFinance);

    }
}
