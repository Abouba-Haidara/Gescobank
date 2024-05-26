package com.bankiapp.repositories;

import com.bankiapp.entities.Operation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
