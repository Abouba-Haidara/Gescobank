package com.bankiapp.repositories;

import com.bankiapp.entities.Client;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ClientRepository  extends JpaRepository<Client, Long> {
}
