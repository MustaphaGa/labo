package com.form.org.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.form.org.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

	@Query(value = "select E from Employe E where E.email = :email")
	Optional<Employe> findEmployesByEmail(@Param("email") String email);

	@Query("SELECT COUNT(e) FROM Employe  e")
	Integer countEmploye();
}
