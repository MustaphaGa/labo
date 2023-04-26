package com.form.org.Repository;

import com.form.org.model.Conge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CongeRepository extends JpaRepository<Conge,Integer> {
    Optional<Conge> findByidConge(Integer idConge);
}
