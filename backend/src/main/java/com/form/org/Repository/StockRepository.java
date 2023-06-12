package com.form.org.Repository;

import com.form.org.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    //Optional<Stock> findByIdStock(Integer idStock);
    Optional<Stock> findBydateStock(Date dateStock);
}
