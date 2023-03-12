package Tests;

import algorithme.chiffrement.AlgorithmeSolitaire;
import algorithme.generateurdecles.GenerateurDeClesSolitaire;
import donnees.cles.CleString;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import entites.Personne;
import entites.Univers;
import exceptions.ExceptionAlgorithmeNonDefini;
import exceptions.ExceptionChiffrementImpossible;
import exceptions.ExceptionConversionImpossible;
import exceptions.ExceptionCryptographie;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmeSolitaireTest {

    @org.junit.jupiter.api.Test
    void getNom() {
        Personne alice = new Personne("Alice");
        alice.setAlgorithme(new AlgorithmeSolitaire());

        assertEquals("Solitaire", alice.getAlgorithme().getNom());
    }

    @org.junit.jupiter.api.Test
    void chiffrer() throws ExceptionCryptographie {
        Personne alice = new Personne("Alice");
        alice.setAlgorithme(new AlgorithmeSolitaire());

        GenerateurDeClesSolitaire clePrivee = new GenerateurDeClesSolitaire(0, Collections.emptyList());
        Cles cles = new Cles();
        cles.addCle("cleSolitaire", new CleString("AAAAA"));

        MessageString msgClair = new MessageString("BB BB Z");
        alice.setClesPrivees(cles);

        Message msgChiff = alice.chiffrer(msgClair, cles);
        Univers.addMessage("Message Alice", msgChiff);

        Message msgRecup = Univers.getMessage("Message Alice");
        assertEquals("CCCCA",msgRecup.asString());

    }

    @org.junit.jupiter.api.Test
    void dechiffrer() throws ExceptionCryptographie {

        Personne alice = new Personne("Alice");
        alice.setAlgorithme(new AlgorithmeSolitaire());

        GenerateurDeClesSolitaire clePrivee = new GenerateurDeClesSolitaire(0, Collections.emptyList());
        Cles cles = new Cles();
        cles.addCle("cleSolitaire", new CleString("AAAAA"));

        MessageString msgChiff = new MessageString("AAABB");
        alice.setClesPrivees(cles);

        Message msgDechiff = alice.dechiffrer(msgChiff, cles);
        Univers.addMessage("Message Alice", msgDechiff);

        Message msgRecup = Univers.getMessage("Message Alice");
        assertEquals("ZZZAA",msgRecup.asString());

    }
}