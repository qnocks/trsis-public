package com.example.lab5.controllers;

import com.example.lab5.domain.Appointment;
import com.example.lab5.services.AppointmentsService;
import com.example.lab5.services.DoctorsService;
import com.example.lab5.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {
    private final AppointmentsService appointmentsService;
    private final DoctorsService doctorsService;
    private final PatientsService patientsService;

    @Autowired
    public AppointmentsController(AppointmentsService appointmentsService,
                                  DoctorsService doctorsService,
                                  PatientsService patientsService) {
        this.appointmentsService = appointmentsService;
        this.doctorsService = doctorsService;
        this.patientsService = patientsService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("appointments", appointmentsService.getAll());
        return "appointments/list";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("appointments", List.of(appointmentsService.get(id)));
        return "appointments/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("appointment") Appointment appointment, Model model) {
        model.addAttribute("doctors", doctorsService.getAll());
        model.addAttribute("patients", patientsService.getAll());
        return "appointments/new";
    }

    @PostMapping("/new")
    public String create(@Valid @ModelAttribute("appointment") Appointment appointment, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "appointments/new";
        }
        appointmentsService.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        appointmentsService.delete(id);
        return "redirect:/appointments";
    }
}
