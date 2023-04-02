package com.form.org.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.DepartementApi;
import com.form.org.Services.DepartementService;
import com.form.org.dto.DepartementDTO;
@RestController
public class DepartementController implements DepartementApi {

	private DepartementService departementService;
	
	@Autowired
	public DepartementController(DepartementService departementService) {
		this.departementService= departementService;
	}
	
	@Override
	public DepartementDTO save(DepartementDTO dto) {
		return departementService.save(dto);
	}

	@Override
	public DepartementDTO findById(Integer idDepartement) {
		return departementService.findById(idDepartement);
	}

	@Override
	public DepartementDTO findByNomDeDepartement(String nomDepartement) {
		return departementService.findByNomDeDepartement(nomDepartement);
	}

	@Override
	public List<DepartementDTO> findAll() {
		return departementService.findAll();
	}

	@Override
	public void delecte(Integer idDepartement) {
		departementService.delete(idDepartement);		
	}

}
