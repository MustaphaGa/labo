package com.form.org.Repository;

import com.form.org.model.AnalyseMedical;
import com.form.org.model.BonCommande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface BonCommandeRepository extends JpaRepository<BonCommande,Integer> {
    Optional<BonCommande> findByIdBonCommande( Integer idBonCommande);
    Optional <BonCommande> findByDateCommande(Date dateCommande);
}
