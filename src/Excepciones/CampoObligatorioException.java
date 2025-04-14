package Excepciones;

public class CampoObligatorioException extends Exception {
    public CampoObligatorioException(String mensaje) {
        super(mensaje);
    }
}
