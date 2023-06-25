package com.form.org.Repository;

import java.util.Date;
import java.util.Optional;

import com.form.org.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import com.form.org.model.AnalyseMedical;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AnalyseMedicalRepository  extends JpaRepository<AnalyseMedical,Integer>{
	
	Optional <AnalyseMedical> findAnalyseMedicalByDateAnalyse(Date dateAnalyse);

	@Query("SELECT COUNT(a) FROM AnalyseMedical a")
	Integer countAnalyseMedical();

}
