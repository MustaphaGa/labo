package com.form.org.Repository;

import com.form.org.model.ServiceFinance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceFinancierRepository extends JpaRepository<ServiceFinance, Integer> {
    Optional<ServiceFinance> findByIdFinance(Integer idFinance);

}
