package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import org.springframework.ui.Model;

import com.example.model.Alumno;
import com.example.service.AlumnoService;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
		
	@Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public String getAllAlumnos(Model model) {
        List<Alumno> alumnos = alumnoService.getAllAlumnos();
        model.addAttribute("alumnos", alumnos);
        return "alumnos"; 
    }

    @GetMapping("/nuevo_alumno")
    public String showNewAlumnoForm(Model model) {
        Alumno alumno = new Alumno();
        model.addAttribute("alumno", alumno);
        return "nuevo_alumno";
    }

    @PostMapping("/guardar")
    public String saveAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoService.createAlumno(alumno);
        return "redirect:/alumnos"; 
    }
	

}
