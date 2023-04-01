package com.form.org.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.FactureApi;
import com.form.org.Services.FactureService;
import com.form.org.dto.FactureDTO;
@RestController
public class FactureController implements FactureApi{
	
	private FactureService factureService;
	
	@Autowired
	public FactureController(FactureService factureService) {
		this.factureService= factureService;
	}

	@Override
	public FactureDTO save(FactureDTO dto) {
		return factureService.save(dto);
	}

	@Override
	public FactureDTO findById(Integer idFacture) {
		return factureService.findById(idFacture);
	}

	@Override
	public List<FactureDTO> findAll() {
		return factureService.findAll();
	}

	@Override
	public void delete(Integer idFacture) {
		factureService.delete(idFacture);
		
	}

}
