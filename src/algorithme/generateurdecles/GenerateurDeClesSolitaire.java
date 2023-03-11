package algorithme.generateurdecles;

import donnees.cles.CleString;
import donnees.cles.Cles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GenerateurDeClesSolitaire implements GenerateurDeCles {

    private final List<Carte> deck = new ArrayList<>();
    private final int taille;

    public GenerateurDeClesSolitaire(int taille){
        this.taille = taille;
    }
    @Override
    public Cles genererClePublique() {
        return null;
    }

    @Override
    public Cles genererClePrivee() {
        Cles cles = new Cles();
        StringBuilder cle = new StringBuilder();
        int i = 0;

        createDeck();
        step1();
        while(i < taille) {
            step2();

            Carte preCarte = deck.get(0);
            Carte theCarte = deck.stream().filter(d -> deck.indexOf(d) == preCarte.getCount()).findFirst().get();

            if (!Objects.equals(preCarte.getSymbole(), "JOKER")) {
                cle.append((char) (((theCarte.getCount() - 1) % 26) + 65));
                i++;
            } else {
                step2();
            }

        }

        cles.addCle("cleSolitaire", new CleString(cle.toString()));
        return cles;
    }

    public void createDeck(){
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
                deck.add(carte);
            }
        }

        //Ajout des deux jokers
        for(int k = 0; k < 2; k++)
        {
            Carte carte = new Carte("JOKER", 53 + k);
            deck.add(carte);
        }
    }

    public void step1 (){
        Collections.shuffle(deck);
    }

    public void step2 (){
        int pos = 0;
        Carte j1 = new Carte("JOKER", 53);
        for(Carte c : deck)
        {
            if(c.getValue() == 53)
            {
                pos = deck.indexOf(c);
            }
        }

        deck.remove(pos);

        pos = ((pos + 1) % 53);
        deck.add(pos, j1);

        step3();
    }

    public void step3 (){
        int pos = 0;
        Carte j2 = new Carte("JOKER", 54);
        for(Carte c : deck)
        {
            if(c.getValue() == j2.getValue())
            {
                pos = deck.indexOf(c);
            }
        }

        deck.remove(pos);

        pos = ((pos + 2) % 53);
        deck.add(pos, j2);

        step4();

    }

    public void step4 (){
        Carte jN = new Carte("JOKER", 53);
        int posN = 0;
        Carte jR = new Carte("JOKER", 54);
        int posR = 0;

        for(Carte c : deck)
        {
            if(c.getValue() == jN.getValue())
            {
                posN = deck.indexOf(c);
            }
            else if (c.getValue() == jR.getValue()){
                posR = deck.indexOf(c);
            }
        }

        int jTop = Math.min(posN, posR);
        int jBot = Math.max(posN, posR);
        List<Carte> top = deck.stream().filter(d -> deck.indexOf(d) < jTop).collect(Collectors.toList());
        List<Carte> bottom = deck.stream().filter(d -> deck.indexOf(d) > jBot).collect(Collectors.toList());

        top.forEach(c -> {
            deck.remove(c);
            deck.add(c);
        });

        AtomicInteger firstPos = new AtomicInteger(0);
        bottom.forEach(c -> {
            deck.remove(c);
            deck.add(firstPos.get(), c);
            firstPos.addAndGet(1);
        });

        step5();

    }

    public void step5 (){
        Carte derCarte = deck.get(deck.size()-1);
        List<Carte> top2 = deck.stream().filter(d -> deck.indexOf(d) < derCarte.getCount()).collect(Collectors.toList());

        deck.remove(derCarte);
        top2.forEach(c -> {
            deck.remove(c);
            deck.add(c);
        });
        deck.add(derCarte);
    }
}
