package co.edu.uceva.estudianteservice.domain.exception;

public class NoHayEstudiantesException extends RuntimeException {
    public NoHayEstudiantesException() {super("No hay estudiantes encontrados");}
}
