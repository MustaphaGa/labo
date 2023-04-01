package com.form.org.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Controller.api.TypeAnalyseApi;
import com.form.org.Services.TypeAnalyseService;
import com.form.org.dto.TypeAnalyseDTO;
@RestController
public class TypeAnalyseController implements TypeAnalyseApi {
	
	private TypeAnalyseService typeAnalyseService;
	
	@Autowired
	public TypeAnalyseController(TypeAnalyseService typeAnalyseService) {
		this.typeAnalyseService = typeAnalyseService;
	}

	@Override
	public TypeAnalyseDTO save(TypeAnalyseDTO dto) {

		return typeAnalyseService.save(dto);
	}

	@Override
	public TypeAnalyseDTO findById(Integer idTypeAnalyse) {
		
		return typeAnalyseService.findById(idTypeAnalyse);
	}

	@Override
	public TypeAnalyseDTO findByTypeAnalyse(String typeAnalyse) {
		
		return typeAnalyseService.findByTypeAnalyse(typeAnalyse);
	}

	@Override
	public List<TypeAnalyseDTO> findAll() {
		
		return typeAnalyseService.findAll();
	}

	@Override
	public void delecte(Integer idTypeAnalyse) {
		typeAnalyseService.delete(idTypeAnalyse);		
	}

}
