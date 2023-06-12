package com.form.org.Repository;

import com.form.org.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompteRepository extends JpaRepository<Compte, Integer> {

}
