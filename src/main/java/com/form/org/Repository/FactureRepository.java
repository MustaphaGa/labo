package com.form.org.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form.org.model.Facture;

public interface FactureRepository extends JpaRepository< Facture, Integer> {

}
