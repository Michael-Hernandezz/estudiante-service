package co.edu.uceva.estudianteservice.model.services;

import co.edu.uceva.estudianteservice.model.entities.Estudiante;
import co.edu.uceva.estudianteservice.model.repositories.IEstudianteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Clase que implementa los métodos de la interfaz IEstudianteService
 * para realizar las operaciones de negocio sobre la entidad Estudiante
 */

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    IEstudianteRepository EstudianteRepository;

    public EstudianteServiceImpl(IEstudianteRepository EstudianteRepository) {
        this.EstudianteRepository = EstudianteRepository;
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        return EstudianteRepository.save(estudiante);
    }
    @Override
    public void delete(Estudiante estudiante) {
        EstudianteRepository.delete(estudiante);
    }


    @Override
    public Estudiante findById(Long id) {
        return EstudianteRepository.findById(id).orElse(null);
    }

    @Override
    public Estudiante findByApellido(String apellido) {
        return EstudianteRepository.findByApellido(apellido);
    }

    @Override
    public Estudiante findByEmail(String email) {
        return EstudianteRepository.findByEmail(email);
    }


    @Override
    public Estudiante update(Estudiante estudiante) {
        return EstudianteRepository.save(estudiante);
    }

    @Override
    public List<Estudiante> findAll() {
        return (List<Estudiante>) EstudianteRepository.findAll();
    }
}
