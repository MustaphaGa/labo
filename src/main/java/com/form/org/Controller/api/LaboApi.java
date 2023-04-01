package com.form.org.Controller.api;


import static com.form.org.utils.Constants.APP_ROOT;
import static com.form.org.utils.Constants.LABO_ENDPOINT;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.form.org.dto.LaboDTO;

import io.swagger.annotations.Api;
@Api(APP_ROOT +"/labo")
public interface LaboApi {
	
	@PostMapping(LABO_ENDPOINT + "/create")
	LaboDTO save(@RequestBody LaboDTO dto);
	
	LaboDTO findById(Integer idLabo);
	
	List<LaboDTO> findAll();
	
	void delete(Integer idLabo);


}
