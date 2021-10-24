package com.example.lab5.repositories;

import com.example.lab5.domain.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends CrudRepository<Appointment, Long> {
}
