package com.form.org.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.BiologisteApi;
import com.form.org.Services.BiologisteService;
import com.form.org.dto.BiologisteDTO;
@RestController
public class BiologisteController implements BiologisteApi {
	
	private BiologisteService  biologisteService;
	
	public BiologisteController(BiologisteService  biologisteService) {
		this.biologisteService= biologisteService;
	}
	@Override
	public BiologisteDTO save(BiologisteDTO dto) {
		return biologisteService.save(dto);
	}

	@Override
	public BiologisteDTO findById(Integer id) {
		return biologisteService.findById(id);
	}

	@Override
	public BiologisteDTO findByCodeBiologiste(String codeBiologiste) {
		return biologisteService.findBiologisteByCode(codeBiologiste);
	}

	@Override
	public List<BiologisteDTO> findAll() {
		return biologisteService.findAll();
	}
	
	@Override
	public void delecte(Integer id) {
		biologisteService.delete(id);
		
	}

}
