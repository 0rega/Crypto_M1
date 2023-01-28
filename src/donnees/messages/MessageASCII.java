package donnees.messages;

import exceptions.ExceptionConversionImpossible;

import java.util.ArrayList;

public class MessageASCII implements Message{

    private ArrayList<Integer> list; //jl'ai crée mais jsuis pas sûre qu'on devait

    /**
     * Constructor
     * @param list
     */
    public MessageASCII(ArrayList<Integer> list){
        this.list = list;

    }
    /***
     * @return Renvoie le mot reconstitué
     * @throws ExceptionConversionImpossible
     */
    @Override
    public String asString() throws ExceptionConversionImpossible {

        String mot = "";

        for(int i = 0;i < list.size();i++){

            //On recupère le nombre
            int lettreInt = list.get(i);

            //On le convertit en char
            char lettre = (char)lettreInt;

            //On ajoute les lettres les unes à la suite des autres pour reformer le mot
            mot += lettre;

        }

        return mot;
    }

    /**
     *
     * @throws ExceptionConversionImpossible
     */
    @Override
    public Integer asInteger() throws ExceptionConversionImpossible {
        throw new ExceptionConversionImpossible("Conversion impossible");
    }

    /**
     *
     * @return Renvoie la liste des codes ascii
     * @throws ExceptionConversionImpossible
     */
    @Override
    public ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible {
        return this.list;
    }

}
