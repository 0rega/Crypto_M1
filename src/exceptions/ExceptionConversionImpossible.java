package exceptions;

public class ExceptionConversionImpossible extends ExceptionCryptographie{

    public ExceptionConversionImpossible(String m) {
        super("Conversion impossible", m);
    }
}
