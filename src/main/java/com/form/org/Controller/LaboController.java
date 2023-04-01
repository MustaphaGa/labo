package com.form.org.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.LaboApi;
import com.form.org.Services.LaboService;
import com.form.org.dto.LaboDTO;

@RestController
public class LaboController implements LaboApi{
	
	private LaboService laboService;
	
	@Autowired
	public LaboController(LaboService laboService) {
		this.laboService=laboService;
		
	}

	@Override
	public LaboDTO save(LaboDTO dto) {
		return laboService.save(dto);
	}

	@Override
	public LaboDTO findById(Integer idLabo) {
		
		return null;
	}

	@Override
	public List<LaboDTO> findAll() {

		return null;
	}

	@Override
	public void delete(Integer idLabo) {
		
	}

}
