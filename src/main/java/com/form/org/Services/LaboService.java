package com.form.org.Services;

import java.util.List;

import com.form.org.dto.LaboDTO;


public interface LaboService {
	
LaboDTO save(LaboDTO dto);
LaboDTO findById(Integer idLabo);
List<LaboDTO> findAll();
void delete(Integer idLabo);

}
