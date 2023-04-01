package com.form.org.Services;

import java.util.List;


import com.form.org.dto.ProfilDTO;

public interface ProfilService {
	
     ProfilDTO save(ProfilDTO dto);
	
     ProfilDTO findById(Integer idProfil);
		
	 List<ProfilDTO>findAll(); 
		
     void delete(Integer idProfil);

}
