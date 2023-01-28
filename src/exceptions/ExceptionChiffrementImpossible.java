package exceptions;

public class ExceptionChiffrementImpossible extends ExceptionCryptographie{
    public ExceptionChiffrementImpossible(String m) {
        super("Chiffrement impossible", m);
    }
}
