package algorithme.chiffrement;

import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageASCII;
import donnees.messages.MessageString;
import exceptions.ExceptionChiffrementImpossible;
import exceptions.ExceptionConversionImpossible;
import exceptions.ExceptionCryptographie;

import java.util.ArrayList;

public class AlgorithmeSolitaire implements Algorithme{
    @Override
    public String getNom() {
        return "Solitaire";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        //Message crypté
        ArrayList<Integer> msgFinale = new ArrayList<>();
        String messageUpper = message.asString().replace(" ", "");
        messageUpper = messageUpper.toUpperCase();
        String clePrivee = clesPrivees.getCle("cleSolitaire").asString();

        try{

           for(int i = 0; i < messageUpper.length(); i++) {
               int msgCharASCII = (int)messageUpper.charAt(i);
               int cleCharASCII = (int)clePrivee.charAt(i);

               msgCharASCII = ((msgCharASCII - 65) + (cleCharASCII - 64)) % 26 + 65;

               msgFinale.add(msgCharASCII);
           }

        }catch (Exception e){
            throw new ExceptionChiffrementImpossible("Chiffrement Impossible");
        }

        Message messageChiffASCII = new MessageASCII(msgFinale);
        MessageString msgChiffre = new MessageString(messageChiffASCII.asString());
        return msgChiffre;
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        //Message crypté
        ArrayList<Integer> msgFinale = new ArrayList<>();
        String clePrivee = clesPrivees.getCle("cleSolitaire").asString();
        String messageUpper = message.asString();

        try{

            for(int i = 0; i < messageUpper.length(); i++) {
                int msgCharASCII = (int)messageUpper.charAt(i);
                int cleCharASCII = (int)clePrivee.charAt(i);

                msgCharASCII = ((msgCharASCII - 65) - (cleCharASCII - 64)) % 26 + 65;

                msgFinale.add(msgCharASCII);
            }

        }catch (Exception e){
            throw new ExceptionChiffrementImpossible("Chiffrement Impossible");
        }

        Message messageChiffASCII = new MessageASCII(msgFinale);
        MessageString msgChiffre = new MessageString(messageChiffASCII.asString());
        return msgChiffre;
    }
}
