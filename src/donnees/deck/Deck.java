package donnees.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    public Deck(){

    }

    public List<Carte> createDeck(){
        List<Carte> cartes = new ArrayList<>();

        String symb = "";
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){

                switch(i){
                    case 0:
                        symb = "TREFLE";
                        break;
                    case 1:
                        symb = "CARREAU";
                        break;
                    case 2:
                        symb = "COEUR";
                        break;
                    case 3:
                        symb = "PIQUE";
                        break;
                }
                Carte carte = new Carte(symb, j + 1);
                cartes.add(carte);
            }
        }

        //Ajout des deux jokers
        for(int k = 0; k < 2; k++)
        {
            Carte carte = new Carte("JOKER", 53 + k);
            cartes.add(carte);
        }

        Collections.shuffle(cartes);

        return cartes;
    }


}
