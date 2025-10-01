package co.edu.uceva.estudianteservice.controllers;

import co.edu.uceva.estudianteservice.model.entities.Estudiante;
import co.edu.uceva.estudianteservice.model.services.IEstudianteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/Estudiante-service")

public class EstudianteRestController {

    private IEstudianteService estudianteService;

    private static final String MENSAJE = "mensaje";
    private static final String Estudiante = "Estudiante";
    private static final String Estudiantes = "Estudiantes";

    public EstudianteRestController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/Estudiantes")
    public ResponseEntity<Map<String, Object>> getEstudiantes(){
        List<Estudiante> estudiantes = estudianteService.findAll();
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put(Estudiantes, estudiantes);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/Estudiantes")
    public ResponseEntity<Map<String, Object>> save(@RequestBody Estudiante estudiante){
        Map<String, Object> respuesta = new HashMap<>();
        Estudiante nuevoEstudiante = estudianteService.save(estudiante);
        respuesta.put(MENSAJE, "El estudiante ha sido creado con exito");
        respuesta.put(Estudiante, nuevoEstudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }



    @GetMapping("/Estudiante/page/{page}")
    public ResponseEntity<Object> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Estudiante> estudiantes = estudianteService.findAll(pageable);
        return ResponseEntity.ok(estudiantes);
    }







}
