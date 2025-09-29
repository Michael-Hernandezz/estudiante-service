package co.edu.uceva.estudianteservice.controllers;

import co.edu.uceva.estudianteservice.model.entities.Estudiante;
import co.edu.uceva.estudianteservice.model.services.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/Estudiante/page/{page}")
    public ResponseEntity<Object> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Estudiante> estudiantes = estudianteService.findAll(pageable);
        return ResponseEntity.ok(estudiantes);
    }







}
