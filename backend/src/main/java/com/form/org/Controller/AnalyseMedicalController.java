package com.form.org.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.AnalyseMedicalApi;
import com.form.org.Services.AnalyseMedicalService;
import com.form.org.dto.AnalyseMedicalDTO;

  @RestController
  public class AnalyseMedicalController implements AnalyseMedicalApi {
	  
	private AnalyseMedicalService analyseMedicalService;
	
	@Autowired
    public AnalyseMedicalController(AnalyseMedicalService analyseMedicalService) {
	this.analyseMedicalService=analyseMedicalService;
	}
	
	@Override
	public AnalyseMedicalDTO save(AnalyseMedicalDTO dto) {
	return analyseMedicalService.save(dto);
	}
	
	@Override
	public AnalyseMedicalDTO findById(Integer idAnalyseMedical) {
	return analyseMedicalService.findById(idAnalyseMedical);
	}
	
	@Override
	public AnalyseMedicalDTO findByDateAnalyse(Date dateAnalyse) {
	return analyseMedicalService.findByDateAnalyse(dateAnalyse) ;
	}

	@Override
	public List<AnalyseMedicalDTO> findAll() {
	return analyseMedicalService.findAll();
	}

	@Override
	public void delecte(Integer idAnalyseMedical) {
	 analyseMedicalService.delete(idAnalyseMedical);
		
	}

}
