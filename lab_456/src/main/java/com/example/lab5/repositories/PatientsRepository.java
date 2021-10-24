package com.example.lab5.repositories;

import com.example.lab5.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends CrudRepository<Patient, Long> {
}
