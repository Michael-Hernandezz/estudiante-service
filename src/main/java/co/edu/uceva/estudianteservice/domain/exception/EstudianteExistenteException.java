package co.edu.uceva.estudianteservice.domain.exception;

public class EstudianteExistenteException extends RuntimeException {
    public EstudianteExistenteException(String nombre) {
        super("El estudiante con nombre" + nombre
        + "Ya existe");
    }
}
