package co.edu.uceva.estudianteservice.domain.exception;

public class PaginaSinEstudiantesException extends RuntimeException {
    public PaginaSinEstudiantesException(int page) {
        super("Pagina sin estudiantes encontrada" + page);
    }
}
