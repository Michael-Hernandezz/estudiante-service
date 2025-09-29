package co.edu.uceva.estudianteservice.model.services;

import co.edu.uceva.estudianteservice.model.entities.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interface que define los métodos que se pueden realizar sobre la entidad Producto
 */


public interface IEstudianteService {
    Estudiante save(Estudiante estudiante);
    void delete(Estudiante estudiante);
    Estudiante findById(Long id);
    Estudiante findByApellido(String apellido);
    Estudiante findByEmail(String email);
    Estudiante update(Estudiante estudiante);
    List<Estudiante> findAll();
    Page<Estudiante> findAll(Pageable pageable);
}
