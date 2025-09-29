package co.edu.uceva.estudianteservice.model.services;

import co.edu.uceva.estudianteservice.model.entities.Estudiante;
import co.edu.uceva.estudianteservice.model.repositories.IEstudianteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase que implementa los métodos de la interfaz IEstudianteService
 * para realizar las operaciones de negocio sobre la entidad Estudiante
 */

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    IEstudianteRepository estudianteRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Estudiante> findAll(Pageable pageable) {
        return estudianteRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    @Transactional
    public void delete(Estudiante estudiante) {
        estudianteRepository.delete(estudiante);
    }

    @Override
    @Transactional
    public Estudiante update(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante findById(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public Estudiante findByApellido(String apellido) {
        return null;
    }

    @Override
    public Estudiante findByEmail(String email) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

}
