package protocoles;

import algorithme.chiffrement.AlgorithmeSolitaire;
import algorithme.generateurdecles.GenerateurDeClesSolitaire;
import donnees.cles.Cles;
import donnees.deck.Carte;
import donnees.deck.Deck;
import donnees.messages.Message;
import donnees.messages.MessageString;
import entites.Personne;
import entites.Univers;
import exceptions.ExceptionCryptographie;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ProtocoleSolitaire  implements Protocole{
    @Override
    public void executer() throws IOException {
        //On crée Alice et Bob
        Personne alice = new Personne("Alice");
        Personne bob = new Personne("Bob");

        alice.setAlgorithme(new AlgorithmeSolitaire());
        bob.setAlgorithme(new AlgorithmeSolitaire());

        String message = "";
        BufferedReader lecteurAvecBuffer = null;
        File doc = new File("D:\\Cours\\M1\\S2\\Cryptographie\\Cryptographie\\Crypto_M1\\src\\fichier.txt");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nVoulez-vous envoyer un fichier ? Y/N");
        String reponse = sc.nextLine();

        if(reponse.toUpperCase().charAt(0) == 'Y'){
            FileInputStream file = new FileInputStream(doc);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine())
            {
                message += " " + scanner.nextLine();
            }
            scanner.close();
        } else {
            System.out.println("\nVeuillez saisir votre message :");
            message = sc.nextLine();
        }

        MessageString msgClair = new MessageString(message);

        Deck deck = new Deck();
        List<Carte> cartes = deck.createDeck();

        GenerateurDeClesSolitaire clePriveeAlice = new GenerateurDeClesSolitaire(message.length(), cartes);
        Cles clesAlice = clePriveeAlice.genererClePrivee();
        alice.setClesPrivees(clesAlice);

        GenerateurDeClesSolitaire clePriveeBob = new GenerateurDeClesSolitaire(message.length(), cartes);
        Cles clesBob = clePriveeBob.genererClePrivee();
        bob.setClesPrivees(clesBob);


        try {
            Message msgChiff = alice.chiffrer(msgClair, clesAlice);
            Univers.addMessage("Message Alice", msgChiff);

            Message msgRecup = Univers.getMessage("Message Alice");
            Message msgFinal = bob.dechiffrer(msgRecup, clesBob);

            System.out.println("\n*****Vous*****");
            System.out.println("Message Clair de vous : " + msgClair.asString());
            System.out.println("\nMessage chiffré par vous : " + msgChiff.asString());
            System.out.println("\n*****Bob*****");
            System.out.println("Message a déchiffré par Bob : " + msgChiff.asString());
            System.out.println("\nMessage déchiffré par Bob : " + msgFinal.asString());
        } catch (ExceptionCryptographie e) {
            e.gerer();
        }

    }
}
