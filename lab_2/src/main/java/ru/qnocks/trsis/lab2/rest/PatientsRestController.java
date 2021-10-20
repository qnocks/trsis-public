package ru.qnocks.trsis.lab2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qnocks.trsis.lab2.dao.PatientsDao;
import ru.qnocks.trsis.lab2.domain.Patient;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientsRestController {
    private final PatientsDao patientsDao;

    @Autowired
    public PatientsRestController(PatientsDao patientsDao) {
        this.patientsDao = patientsDao;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> list() {
        return new ResponseEntity<>(patientsDao.findALl(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Patient> show(@PathVariable("id") Long id) {
        Patient patient = patientsDao.findById(id);
        if (patient == null) {
            throw new IllegalArgumentException("Cannot find patient with id " + id);
        }
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> save(@Valid @RequestBody Patient patient) {
        return new ResponseEntity<>(patientsDao.save(patient), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        patientsDao.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
