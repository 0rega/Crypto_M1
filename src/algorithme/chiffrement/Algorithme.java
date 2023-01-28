package algorithme.chiffrement;

import donnees.cles.Cles;
import donnees.messages.Message;
import exceptions.ExceptionConversionImpossible;

public interface Algorithme {
    String nom = "";

    public String getNom();

    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionConversionImpossible;
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees);
}
