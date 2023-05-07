package com.form.org.Repository;

import com.form.org.model.GestionStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GestionStockRepository extends JpaRepository<GestionStock,Integer> {
    Optional<GestionStock> findByIdGesStock(Integer idGesStock);
}
