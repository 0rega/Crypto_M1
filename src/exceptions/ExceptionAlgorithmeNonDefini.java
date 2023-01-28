package exceptions;

public class ExceptionAlgorithmeNonDefini extends ExceptionCryptographie{
    public ExceptionAlgorithmeNonDefini(String m) {
        super("Erreur Algorithme non défini", m);
    }
}
