package algorithme.chiffrement;

import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import exceptions.ExceptionConversionImpossible;

public class AlgorithmeSolitaire implements Algorithme{
    @Override
    public String getNom() {
        return "Solitaire";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionConversionImpossible {

        //Message crypté
        String messageCrypte = "";

        char[] tabCle = new char[54];

        int tailleMsg = message.asString().length();

        for(int i = 0; i < tailleMsg; i++)
        {
            char c = message.asString().charAt(i);
            char cKey = tabCle[i];
            c -= 64;
            int valChar = ((int)c + cKey) % 26;

            messageCrypte += (char)valChar;
        }

        message = new MessageString(messageCrypte);

        return message;
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) {
        return message;
    }
}
