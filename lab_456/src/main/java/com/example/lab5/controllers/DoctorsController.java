package com.example.lab5.controllers;

import com.example.lab5.domain.Doctor;
import com.example.lab5.services.AppointmentsService;
import com.example.lab5.services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorsController {
    private final DoctorsService doctorsService;
    private final AppointmentsService appointmentsService;

    @Autowired
    public DoctorsController(DoctorsService doctorsService, AppointmentsService appointmentsService) {
        this.doctorsService = doctorsService;
        this.appointmentsService = appointmentsService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("doctors", doctorsService.getAll());
        return "doctors/list";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("doctors", List.of(doctorsService.get(id)));
        return "doctors/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("doctor") Doctor doctor) {
        return "doctors/new";
    }

    @PostMapping("/new")
    public String create(@Valid @ModelAttribute Doctor doctor, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "doctors/new";
        }
        doctorsService.save(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        doctorsService.delete(id);
        appointmentsService.deleteByDoctorId(id);
        return "redirect:/doctors";
    }
}
