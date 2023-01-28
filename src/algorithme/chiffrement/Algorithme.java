package algorithme.chiffrement;

import donnees.cles.Cles;
import donnees.messages.Message;

public interface Algorithme {
    String nom = "";

    public String getNom();

    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees);
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees);
}
