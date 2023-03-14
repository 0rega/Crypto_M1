package protocoles;

import exceptions.ExceptionConversionImpossible;
import exceptions.ExceptionCryptographie;

import java.io.IOException;

public interface Protocole {

    public void init();

    public String chiffrer(String message) throws ExceptionCryptographie;

    public String dechiffrer(String message)throws ExceptionCryptographie ;

}
