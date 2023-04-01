package com.form.org.Services;

import java.util.List;
import com.form.org.dto.DetailResultatDTO;

public interface DetailResultatService {

	
	DetailResultatDTO save(DetailResultatDTO dto);

	DetailResultatDTO findById(Integer idDetailResultat);
		
	List<DetailResultatDTO>findAll(); 
		
	void delete(Integer idDetailResultat);

}
