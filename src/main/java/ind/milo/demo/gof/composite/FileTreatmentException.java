package ind.milo.demo.gof.composite;

public class FileTreatmentException extends RuntimeException {
    public FileTreatmentException() {
    }

    public FileTreatmentException(String message) {
        super(message);
    }
}
