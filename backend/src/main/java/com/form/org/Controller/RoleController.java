package com.form.org.Controller;

import com.form.org.Controller.api.RoleApi;
import com.form.org.Services.RolesService;
import com.form.org.dto.RolesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController implements RoleApi {


    private RolesService rolesService;

    @Autowired
    public RoleController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @Override
    public RolesDTO save(RolesDTO dto) {
        return rolesService.save(dto);
    }

    @Override
    public RolesDTO findById(Integer idRole) {
        return null;
    }

    @Override
    public List<RolesDTO> findAll() {
        return rolesService.findAll();
    }

    @Override
    public void delecte(Integer idRole) {
        rolesService.delete(idRole);

    }
}
