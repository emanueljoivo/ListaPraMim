package listaDeComprasExceptions;

public class CompraNotExistException extends Exception {
    public CompraNotExistException(String errorMessage) {
        super(errorMessage);
    }
}
