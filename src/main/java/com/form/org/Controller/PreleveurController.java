package com.form.org.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.PreleveurApi;
import com.form.org.Services.PreleveurService;
import com.form.org.dto.PreleveurDTO;
@RestController
public class PreleveurController implements PreleveurApi{
	
	private PreleveurService  preleveurService;
	
	@Autowired
    public PreleveurController(PreleveurService  preleveurService) {
		this.preleveurService= preleveurService;
	}


	@Override
	public PreleveurDTO save(PreleveurDTO dto) {
		
		return preleveurService.save(dto);
	}

	@Override
	public PreleveurDTO findById(Integer idPreleveur) {

		return preleveurService.findById(idPreleveur);
	}

	@Override
	public PreleveurDTO findBySpecialite(String specialite) {
		
		return preleveurService.findBySpecialite(specialite);
	}

	@Override
	public List<PreleveurDTO> findAll() {
		return preleveurService.findAll();
	}

	@Override
	public void delete(Integer idPreleveur) {
		preleveurService.delete(idPreleveur);
	}

}
