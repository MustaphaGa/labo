package com.form.org.Repository;

import com.form.org.model.Absence;
import com.form.org.model.Mouvement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MouvementRepository extends JpaRepository<Mouvement, Integer> {
    Optional<Mouvement> findByIdMouvement(Integer idMouvement);
    Optional<Mouvement> findByTypeMouvement(String typeMouvement);
}
