package com.form.org.Services;

import java.util.List;
import com.form.org.dto.FactureDTO;

public interface FactureService {
	
	FactureDTO save(FactureDTO dto);

	FactureDTO findById(Integer idFacture);
		
    List<FactureDTO>findAll(); 
		
    void delete(Integer idFacture);

}
