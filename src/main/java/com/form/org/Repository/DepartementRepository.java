package com.form.org.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.form.org.model.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Integer>{
	
	Optional <Departement> findDepartementByNomDepartement(String nomdepartement);

}
