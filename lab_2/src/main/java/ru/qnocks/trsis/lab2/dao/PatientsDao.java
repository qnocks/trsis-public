package ru.qnocks.trsis.lab2.dao;

import org.springframework.stereotype.Component;
import ru.qnocks.trsis.lab2.domain.Patient;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class PatientsDao implements CrudDao<Patient, Long> {

    private long id = 0L;
    private Map<Long, Patient> patients = new HashMap<>();

    @Override
    public Patient save(Patient entity) {
        entity.setId(id++);
        patients.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void delete(Long id) {
        patients.remove(id);
    }

    @Override
    public Patient findById(Long id) {
        return patients.get(id);
    }

    @Override
    public List<Patient> findALl() {
        return new LinkedList<>(patients.values());
    }
}
