package algorithme.chiffrement;

import donnees.cles.Cles;
import donnees.messages.Message;
import exceptions.ExceptionChiffrementImpossible;
import exceptions.ExceptionConversionImpossible;
import exceptions.ExceptionCryptographie;

public interface Algorithme {
    String nom = "";

    public String getNom();

    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie;
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie;
}
