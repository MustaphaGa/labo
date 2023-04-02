package com.form.org.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.form.org.model.Biologiste;

public interface BiologisteRepository extends JpaRepository<Biologiste,Integer>{
	
	Optional<Biologiste> findBiologisteByCodeBiologiste(final String codeBiologiste);

	//List<Biologiste> findAllByDepartementId(Integer idDepartement);
}
