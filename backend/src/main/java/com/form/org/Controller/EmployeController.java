package com.form.org.Controller;

import com.form.org.Controller.api.EmployeApi;
import com.form.org.Services.EmployeService;
import com.form.org.dto.EmployeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeController implements EmployeApi {

    private EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @Override
    public EmployeDTO save(EmployeDTO dto) {
        return employeService.save(dto);
    }

    @Override
    public EmployeDTO findById(Integer idEmploye) {
        return employeService.findById(idEmploye);
    }

    @Override
    public EmployeDTO findByEmail(String email) {
        return employeService.findByEmail(email);
    }

    @Override
    public List<EmployeDTO> findAll() {
        return employeService.findAll();
    }

    @Override
    public void delecte(Integer idEmploye) {
        employeService.delete(idEmploye);

    }
}
