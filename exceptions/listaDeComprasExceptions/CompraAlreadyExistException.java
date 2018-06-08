package listaDeComprasExceptions;

public class CompraAlreadyExistException extends Exception {
    public CompraAlreadyExistException(String errorMessage) { super(errorMessage); }
}
