package co.edu.uceva.estudianteservice.model.repositories;

import co.edu.uceva.estudianteservice.model.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface que hereda de CrudRepository para realizar las
 * operaciones de CRUD sobre la entidad Producto
 */
//Debe especificarse la entidad y el tipo de Dato primario, es decir, Long por Id
public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {
}
