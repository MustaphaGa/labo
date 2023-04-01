package com.form.org.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.ProfilApi;
import com.form.org.Services.ProfilService;
import com.form.org.dto.ProfilDTO;
@RestController
public class ProfilController implements ProfilApi{
	
	private ProfilService profilService;

	@Autowired
	public ProfilController(ProfilService profilService) {
		this.profilService= profilService;
	}
	
	@Override
	public ProfilDTO save(ProfilDTO dto) {
		return profilService.save(dto) ;
	}

	@Override
	public ProfilDTO findById(Integer idProfil) {
		
		return profilService.findById(idProfil);
	}

	@Override
	public List<ProfilDTO> findAll() {
	
		return profilService.findAll();
	}

	@Override
	public void delete(Integer idProfil) {
		profilService.delete(idProfil);
	}

}
