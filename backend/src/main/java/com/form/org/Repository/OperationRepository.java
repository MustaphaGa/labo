package com.form.org.Repository;

import com.form.org.model.Absence;
import com.form.org.model.Operation;
import com.form.org.model.ServiceFinance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface OperationRepository extends JpaRepository<Operation, Integer> {
    Optional<Operation> findByidOperation(Integer idOperation);
    Optional<Operation> findByDateOperation(Date dateOperation);
}
