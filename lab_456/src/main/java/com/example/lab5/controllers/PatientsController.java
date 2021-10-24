package com.example.lab5.controllers;

import com.example.lab5.domain.Patient;
import com.example.lab5.services.AppointmentsService;
import com.example.lab5.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientsController {
    private final PatientsService patientsService;
    private final AppointmentsService appointmentsService;

    @Autowired
    public PatientsController(PatientsService patientsService, AppointmentsService appointmentsService) {
        this.patientsService = patientsService;
        this.appointmentsService = appointmentsService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("patients", patientsService.getAll());
        return "patients/list";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("patients", List.of(patientsService.get(id)));
        return "patients/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("patient") Patient patient) {
        return "patients/new";
    }

    @PostMapping("/new")
    public String create(@Valid @ModelAttribute Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "patients/new";
        }
        patientsService.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        patientsService.delete(id);
        appointmentsService.deleteByPatientId(id);
        return "redirect:/patients";
    }
}

