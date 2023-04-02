package com.form.org.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.UtilisateurApi;
import com.form.org.Services.UtilisateurService;
import com.form.org.dto.UtilisateurDTO;

@RestController
public class UtilisateurController implements UtilisateurApi{
	
	private UtilisateurService utilisateurService;
	
	@Autowired
	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService= utilisateurService;
		
	}

	@Override
	public UtilisateurDTO save(UtilisateurDTO dto) {
		return utilisateurService.save(dto);
	}

	@Override
	public UtilisateurDTO findById(Integer id) {
		return utilisateurService.findById(id);
	}

	@Override
	public List<UtilisateurDTO> findAll() {
		return utilisateurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		utilisateurService.delete(id);
		
	}

	

}
