package ru.qnocks.trsis.lab2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qnocks.trsis.lab2.dao.DoctorsDao;
import ru.qnocks.trsis.lab2.domain.Doctor;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorsRestController {
    private final DoctorsDao doctorsDao;

    @Autowired
    public DoctorsRestController(DoctorsDao doctorsDao) {
        this.doctorsDao = doctorsDao;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> list() {
        return new ResponseEntity<>(doctorsDao.findALl(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Doctor> show(@PathVariable("id") Long id) {
        Doctor doctor = doctorsDao.findById(id);
        if (doctor == null) {
            throw new IllegalArgumentException("Cannot find doctor with id " + id);
        }
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> save(@Valid @RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorsDao.save(doctor), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        doctorsDao.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
