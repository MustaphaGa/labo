package com.form.org.Services;

import java.util.List;
import com.form.org.dto.DepartementDTO;

public interface DepartementService {
	
	DepartementDTO save(DepartementDTO dto);
		
	DepartementDTO findById(Integer idDepartement);
		
	DepartementDTO findByNomDeDepartement(String nomDepartement);
		
    List<DepartementDTO>findAll(); 
		
	void delete(Integer idDepartement);


}
