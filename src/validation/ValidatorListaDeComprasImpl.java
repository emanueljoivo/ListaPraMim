package validation;

public class ValidatorListaDeComprasImpl extends Validator implements ValidatorListaDeCompras {

    @Override
    public void validaDescritor(String descritor) throws IllegalArgumentException, NullPointerException {
        this.validatorString(descritor);
    }


}
