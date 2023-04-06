package com.form.org.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.form.org.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
	@Query("select u from Utilisateur u where u.email = :email") 
	Optional<Employe> findUtilisateurByEmail(@Param("email") String email);

}
