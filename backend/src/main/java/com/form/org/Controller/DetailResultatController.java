package com.form.org.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.DetailResultatApi;
import com.form.org.Services.DetailResultatService;
import com.form.org.dto.DetailResultatDTO;
@RestController
public class DetailResultatController implements DetailResultatApi{

	private DetailResultatService detailResultatService;
	
	@Autowired
	public DetailResultatController(DetailResultatService detailResultatService) {
		this.detailResultatService=detailResultatService;
	}
	@Override
	public DetailResultatDTO save(DetailResultatDTO dto) {
		return detailResultatService.save(dto);
	}

	@Override
	public DetailResultatDTO findById(Integer idDetailResultat) {
	
		return detailResultatService.findById(idDetailResultat);
	}

	@Override
	public List<DetailResultatDTO> findAll() {	
		return detailResultatService.findAll();
	}

	@Override
	public void delecte(Integer idDetailResultat) {	
	        detailResultatService.delete(idDetailResultat);
	}

}
