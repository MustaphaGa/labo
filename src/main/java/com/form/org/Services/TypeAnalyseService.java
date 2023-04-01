package com.form.org.Services;

import java.util.List;

import com.form.org.dto.TypeAnalyseDTO;

public interface TypeAnalyseService {

	TypeAnalyseDTO save(TypeAnalyseDTO dto);
	
	TypeAnalyseDTO findById(Integer idTypeAnalyse);
		
	TypeAnalyseDTO findByTypeAnalyse(String typeAnalyse);
		
	List<TypeAnalyseDTO>findAll(); 
		
    void delete(Integer idTypeAnalyse);

}
