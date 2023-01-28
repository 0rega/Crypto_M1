package algorithme.chiffrement;

import donnees.cles.Cles;
import donnees.messages.Message;

public class AlgorithmeSolitaire implements Algorithme{
    @Override
    public String getNom() {
        return "Solitaire";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) {
        return null;
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) {
        return null;
    }
}
