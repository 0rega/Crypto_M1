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
import exceptions.ExceptionConversionImpossible;
import exceptions.ExceptionCryptographie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProtocoleSolitaire  implements Protocole{

    Personne alice = new Personne("Alice");
    Personne bob = new Personne("Bob");
    Deck deck = new Deck();
    List<Carte> cartes = new ArrayList<>();
    @Override
    public void init(){

        alice.setAlgorithme(new AlgorithmeSolitaire());
        bob.setAlgorithme(new AlgorithmeSolitaire());

        cartes = deck.createDeck();
    }

    public String chiffrer(String message) throws ExceptionCryptographie {
        init();
        message = message.replaceAll("[^a-zA-Z]", "");
        Message msgChiff = new MessageString(message);
        try{
            GenerateurDeClesSolitaire clePriveeAlice = new GenerateurDeClesSolitaire(message.length(), cartes);
            Cles clesAlice = clePriveeAlice.genererClePrivee();
            alice.setClesPrivees(clesAlice);

            msgChiff = alice.chiffrer(msgChiff, clesAlice);
            Univers.addMessage("Message Alice", msgChiff);

        }catch(ExceptionCryptographie e) {
            e.gerer();
        }

        return msgChiff.asString();
    }

    public String dechiffrer(String message)throws ExceptionCryptographie {
        Message msgFinal = new MessageString("");
        try{
            GenerateurDeClesSolitaire clePriveeBob = new GenerateurDeClesSolitaire(message.length(), cartes);
            Cles clesBob = clePriveeBob.genererClePrivee();
            bob.setClesPrivees(clesBob);

            Message msgRecup = Univers.getMessage("Message Alice");
            msgFinal = bob.dechiffrer(msgRecup, clesBob);

        }catch(ExceptionCryptographie e) {
            e.gerer();
        }

        return msgFinal.asString();
    }
}
