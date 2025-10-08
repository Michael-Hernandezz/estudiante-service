package co.edu.uceva.estudianteservice.delivery.rest;

import co.edu.uceva.estudianteservice.domain.exception.EstudianteNoEncontradoException;
import co.edu.uceva.estudianteservice.domain.exception.PaginaSinEstudiantesException;
import co.edu.uceva.estudianteservice.domain.exception.ValidationException; // <- tu excepción del dominio
import co.edu.uceva.estudianteservice.domain.model.Estudiante;
import co.edu.uceva.estudianteservice.domain.service.IEstudianteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/estudiante-service")
public class EstudianteRestController {

    private final IEstudianteService estudianteService;

    private static final String MENSAJE = "mensaje";
    private static final String ESTUDIANTE = "estudiante";
    private static final String ESTUDIANTES = "estudiantes";

    public EstudianteRestController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<Map<String, Object>> getEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.findAll();
        if (estudiantes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put(ESTUDIANTES, estudiantes);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/estudiantes")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Estudiante estudiante, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        Map<String, Object> respuesta = new HashMap<>();
        Estudiante nuevoEstudiante = estudianteService.save(estudiante);
        respuesta.put(MENSAJE, "El estudiante ha sido creado con éxito");
        respuesta.put(ESTUDIANTE, nuevoEstudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    @GetMapping("/estudiante/page/{page}")
    public ResponseEntity<Object> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Estudiante> estudiantes = estudianteService.findAll(pageable);
        if (estudiantes.isEmpty()) {
            throw new PaginaSinEstudiantesException(page);
        }
        return ResponseEntity.ok(estudiantes);
    }

    @DeleteMapping("/estudiantes")
    public ResponseEntity<Map<String, Object>> delete(@RequestBody Estudiante estudiante) {
        Long id = estudiante.getId();
        estudianteService.findById(id).orElseThrow(() -> new EstudianteNoEncontradoException(id));
        estudianteService.delete(estudiante);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put(MENSAJE, "El estudiante ha sido eliminado con éxito!");
        respuesta.put(ESTUDIANTE, null);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/estudiantes")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Estudiante estudiante, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        Long id = estudiante.getId();
        estudianteService.findById(id).orElseThrow(() -> new EstudianteNoEncontradoException(id));
        Estudiante estudianteActualizado = estudianteService.update(estudiante);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put(MENSAJE, "El estudiante ha sido actualizado con éxito!");
        respuesta.put(ESTUDIANTE, estudianteActualizado);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.findById(id)
                .orElseThrow(() -> new EstudianteNoEncontradoException(id));
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put(MENSAJE, "El estudiante ha sido encontrado con éxito!");
        respuesta.put(ESTUDIANTE, estudiante);
        return ResponseEntity.ok(respuesta);
    }
}
