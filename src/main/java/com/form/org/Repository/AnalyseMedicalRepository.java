package com.form.org.Repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form.org.model.AnalyseMedical;


public interface AnalyseMedicalRepository  extends JpaRepository<AnalyseMedical,Integer>{
	
	Optional <AnalyseMedical> findAnalyseMedicalByDateAnalyse(Date dateAnalyse);

}
