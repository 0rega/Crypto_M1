package protocoles;

import algorithme.chiffrement.AlgorithmeSolitaire;
import algorithme.generateurdecles.GenerateurDeClesSolitaire;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import entites.Personne;
import entites.Univers;
import exceptions.ExceptionCryptographie;

public class ProtocoleSolitaire  implements Protocole{
    @Override
    public void executer() {
        //On crée Alice et Bob
        Personne alice = new Personne("Alice");
        Personne bob = new Personne("Bob");

        alice.setAlgorithme(new AlgorithmeSolitaire());
        bob.setAlgorithme(new AlgorithmeSolitaire());

        GenerateurDeClesSolitaire clePrivee = new GenerateurDeClesSolitaire(6);
        Cles cles = clePrivee.genererClePrivee();
        alice.setClesPrivees(cles);
        bob.setClesPrivees(cles);

        String message = "AAAAA";
        MessageString msgClair = new MessageString(message);

        try {
            Message msgChiff = alice.chiffrer(msgClair, cles);
            Univers.addMessage("Message Alice", msgChiff);

            Message msgRecup = Univers.getMessage("Message Alice");
            Message msgFinal = bob.dechiffrer(msgRecup, cles);

            System.out.println("*****Alice*****");
            System.out.println("Message Clair d'Alice : " + msgClair.asString());
            System.out.println("\nMessage chiffré par Alice : " + msgChiff.asString());
            System.out.println("\n*****Bob*****");
            System.out.println("Message a déchiffré par Bob : " + msgChiff.asString());
            System.out.println("\nMessage déchiffré par Bob : " + msgFinal.asString());
        } catch (ExceptionCryptographie e) {
            e.gerer();
        }
    }
}
