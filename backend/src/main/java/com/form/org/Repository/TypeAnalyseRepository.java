package com.form.org.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.form.org.model.TypeAnalyse;

public interface TypeAnalyseRepository extends JpaRepository<TypeAnalyse, Integer>{

	
	Optional<TypeAnalyse> findByTypeAnalyse(String typeAnalyse);
}
