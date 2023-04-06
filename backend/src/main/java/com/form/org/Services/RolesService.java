package com.form.org.Services;

import java.util.List;

import com.form.org.dto.RolesDTO;

public interface RolesService {
	
	RolesDTO save(RolesDTO dto);
	
	RolesDTO findById(Integer idRole);
		
	 List<RolesDTO>findAll(); 
		
     void delete(Integer idRole);

}
