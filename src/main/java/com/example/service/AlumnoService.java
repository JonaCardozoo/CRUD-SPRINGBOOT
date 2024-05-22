package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.model.Alumno;


import com.example.repository.AlumnoRepository;

@Service
public class AlumnoService {
	
	@Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno getAlumnoById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    public Alumno createAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno updateAlumno(Long id, Alumno alumnoDetails) {
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        if (alumno != null) {
            alumno.setNombre(alumnoDetails.getNombre());
            alumno.setApellido(alumnoDetails.getApellido());
            alumno.setEmail(alumnoDetails.getEmail());
            return alumnoRepository.save(alumno);
        }
        return null;
    }

    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
    
    
   
}
