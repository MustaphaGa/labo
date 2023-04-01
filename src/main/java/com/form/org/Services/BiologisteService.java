package com.form.org.Services;

import java.util.List;

import com.form.org.dto.BiologisteDTO;

public interface BiologisteService {
	
	 BiologisteDTO save(BiologisteDTO dto);
		
	 BiologisteDTO findById(Integer id);
		
	 BiologisteDTO findBiologisteByCode(String codeBiologiste);
		
	 List<BiologisteDTO>findAll(); 
		
	 void delete(Integer id);

}
