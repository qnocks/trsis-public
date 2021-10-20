package ru.qnocks.trsis.lab2.domain;


import javax.validation.constraints.NotNull;

public class Doctor {
    private Long id;
    @NotNull
    private String fullName;
    @NotNull
    private String specialty;
    @NotNull
    private String schedule;

    public Doctor(String fullName, String specialty, String schedule) {
        this.fullName = fullName;
        this.specialty = specialty;
        this.schedule = schedule;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
