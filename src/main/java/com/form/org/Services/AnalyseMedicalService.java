package com.form.org.Services;

import java.util.Date;
import java.util.List;

import com.form.org.dto.AnalyseMedicalDTO;

public interface AnalyseMedicalService {
	
    AnalyseMedicalDTO save(AnalyseMedicalDTO dto);
	
    AnalyseMedicalDTO findById(Integer idAnalyseMedical);
	
    AnalyseMedicalDTO findByDateAnalyse(Date dateAnalyse);
	
	List<AnalyseMedicalDTO>findAll(); 
	
	void delete(Integer idAnalyseMedical);

}
