package com.bankiapp.repositories;

import com.bankiapp.entities.Client;
import com.bankiapp.entities.Employee;
import com.bankiapp.entities.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByFirstNameContaining(String keyword);
}
