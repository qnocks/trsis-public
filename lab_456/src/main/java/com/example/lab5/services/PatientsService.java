package com.example.lab5.services;

import com.example.lab5.domain.Patient;
import com.example.lab5.repositories.PatientsRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientsService {
    private final PatientsRepository patientsRepository;

    @Autowired
    public PatientsService(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    public List<Patient> getAll() {
        return (List<Patient>) patientsRepository.findAll();
    }

    public Patient get(Long id) {
        return patientsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find Patient id: " + id));
    }

    public Patient save(Patient patient) {
        return patientsRepository.save(patient);
    }

    @SneakyThrows
    public Patient update(Long id, Patient patient) {
         throw new NoSuchMethodException();
    }

    public void delete(Long id) {
        patientsRepository.deleteById(id);
    }
}
