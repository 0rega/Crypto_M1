package donnees.cles;

import exceptions.ExceptionConversionImpossible;

public interface Cle {
    public String asString() throws ExceptionConversionImpossible;

    public int asInteger() throws ExceptionConversionImpossible;

}
