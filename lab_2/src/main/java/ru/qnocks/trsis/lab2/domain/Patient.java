package ru.qnocks.trsis.lab2.domain;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Patient {
    private Long id;
    @NotNull
    private String fullName;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private String address;

    public Patient(String fullName, LocalDate birthDate, String address) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
