package com.form.org.Repository;

import com.form.org.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
  //  Optional<Fournisseur> findByidFournisseur(Integer idFournisseur);
    //Optional<Fournisseur> findByNom(String nom);
}
