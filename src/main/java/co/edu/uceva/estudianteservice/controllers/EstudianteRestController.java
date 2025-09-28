package co.edu.uceva.estudianteservice.controllers;

import co.edu.uceva.estudianteservice.model.entities.Estudiante;
import co.edu.uceva.estudianteservice.model.services.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Estudiante-service")

public class EstudianteRestController {

    private IEstudianteService estudianteService;

    @Autowired
    public EstudianteRestController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/Estudiantes")
    public List<Estudiante> getEstudiantes() {
        return estudianteService.findAll();
    }

    @PostMapping("/Estudiantes")
    public Estudiante save(@RequestBody Estudiante estudiante) {
        return estudianteService.save(estudiante);
    }

    @DeleteMapping("/Estudiantes")
    public void delete(@RequestBody Estudiante estudiante) {
        estudianteService.delete(estudiante);
    }

    @PutMapping("/Estudiantes")
    public Estudiante update(@RequestBody Estudiante estudiante) {
        return estudianteService.update(estudiante);
    }

    @GetMapping("/Estudiantes/{id}")
    public Estudiante findById(@PathVariable("id") Long id) {
        return estudianteService.findById(id);
    }
    @GetMapping("/Estudiantes/{apellido}")
    public Estudiante findByApellido(@PathVariable("apellido") String apellido) {
        return estudianteService.findByApellido(apellido);
    }
    @GetMapping("/Estudiantes/{email}")
    public Estudiante findByEmail(@PathVariable("email") String email) {
        return estudianteService.findByEmail(email);
    }





}
