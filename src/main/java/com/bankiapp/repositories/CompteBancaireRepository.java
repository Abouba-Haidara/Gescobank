package com.bankiapp.repositories;

import com.bankiapp.entities.CompteBancaire;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long> {
}
