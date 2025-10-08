package co.edu.uceva.estudianteservice.domain.exception;

public class EstudianteNoEncontradoException extends RuntimeException {
    public EstudianteNoEncontradoException(Long id) {
        super("el estudiante con el id " + id + " no existe");
    }
}
