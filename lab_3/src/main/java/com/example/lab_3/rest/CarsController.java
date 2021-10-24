package com.example.lab_3.rest;

import com.example.lab_3.dao.CarsDao;
import com.example.lab_3.dao.PurchasesDao;
import com.example.lab_3.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "http://localhost:3000")
public class CarsController {
    private final CarsDao carsDao;
    private final PurchasesDao purchasesDao;

    @Autowired
    public CarsController(CarsDao carsDao, PurchasesDao purchasesDao) {
        this.carsDao = carsDao;
        this.purchasesDao = purchasesDao;
    }

    @GetMapping
    public ResponseEntity<List<Car>> list() {
        return new ResponseEntity<>(carsDao.findALl(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> show(@PathVariable("id") Long id) {
        Car car = carsDao.findById(id);
        if (car == null) {
            throw new IllegalArgumentException("Cannot find car with id " + id);
        }
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> save(@Valid @RequestBody Car car) {
        return new ResponseEntity<>(carsDao.save(car), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        carsDao.delete(id);
        purchasesDao.deleteByCarId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
