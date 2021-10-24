package com.example.lab5.repositories;

import com.example.lab5.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository extends CrudRepository<Doctor, Long> {
}
