package com.form.org.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form.org.model.DetailResultat;


public interface DetailResultatRepository  extends JpaRepository<DetailResultat, Integer>  {
	
//	@Query("select * from medcin where code_medcin = :code and nom_medcin = :nom")
//	List<Medcin> findByCustomQuery(@Param("code")String c, @Param("nom") String n);
//	
//	@Query(value = "select * from medcin where code_medcin = :code", nativeQuery = true)
//	List<Medcin> findByCustomNativeQuery(@Param("code")String c);
//	
//	
//	List<Medcin> findByCodeMedcinIgnoreCaseAndNomMedcinIgnoreCase(String code_medcin, String nom_medcin);

}
