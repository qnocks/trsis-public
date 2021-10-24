package com.example.lab5.services;

import com.example.lab5.domain.Appointment;
import com.example.lab5.domain.Doctor;
import com.example.lab5.domain.Patient;
import com.example.lab5.repositories.AppointmentsRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsService {
    private final AppointmentsRepository appointmentsRepository;
    private final DoctorsService doctorsService;
    private final PatientsService patientsService;

    @Autowired
    public AppointmentsService(AppointmentsRepository appointmentsRepository,
                               DoctorsService doctorsService,
                               PatientsService patientsService) {
        this.appointmentsRepository = appointmentsRepository;
        this.doctorsService = doctorsService;
        this.patientsService = patientsService;
    }

    public List<Appointment> getAll() {
        return (List<Appointment>) appointmentsRepository.findAll();
    }

    public Appointment get(Long id) {
        return appointmentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find Appointment id: " + id));
    }

    public Appointment save(Appointment appointment) {
        String doctorName = appointment.getDoctor().getFullName();
        Doctor doctor = doctorsService.getAll().stream()
                .filter(d -> d.getFullName().equals(doctorName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find Doctor with full name " + doctorName));

        String patientName = appointment.getPatient().getFullName();
        Patient patient = patientsService.getAll().stream()
                .filter(p -> p.getFullName().equals(patientName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find Patient with full name " + patientName));

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        return appointmentsRepository.save(appointment);
    }

    @SneakyThrows
    public Appointment update(String id, Appointment appointment) {
        throw new NoSuchMethodException();
    }

    public void delete(Long id) {
        appointmentsRepository.deleteById(id);
    }

    public void deleteByDoctorId(Long id) {
        Appointment appointment = getAll().stream()
                .filter(a -> a.getDoctor().getId().equals(id))
                .findFirst()
                .orElse(null);

        if (appointment == null) return;
        appointmentsRepository.delete(appointment);
    }

    public void deleteByPatientId(Long id) {
        Appointment appointment = getAll().stream()
                .filter(a -> a.getPatient().getId().equals(id))
                .findFirst()
                .orElse(null);

        if (appointment == null) return;
        appointmentsRepository.delete(appointment);
    }
}
