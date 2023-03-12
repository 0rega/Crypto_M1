import donnees.deck.Carte;
import donnees.deck.Deck;
import donnees.messages.Message;
import donnees.messages.MessageASCII;
import donnees.messages.MessageString;
import exceptions.ExceptionChiffrementImpossible;
import exceptions.ExceptionConversionImpossible;
import protocoles.Protocole;
import protocoles.ProtocoleSolitaire;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ExceptionConversionImpossible, IOException {

        System.out.println("Algorithme Solitaire");
        Protocole protoS = new ProtocoleSolitaire();

        while(true){
            protoS.executer();
        }

    }

}
