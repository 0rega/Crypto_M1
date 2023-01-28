package donnees.messages;

import exceptions.ExceptionConversionImpossible;

import java.util.ArrayList;

public class MessageString implements Message {
    private String message;

    public MessageString(String message) {
        this.message = message;
    }

    /**
     * Renvoie le message sous forme d’une chaine de caractère
     * @return result : le message à envoyer
     */
    @Override
    public String asString() throws ExceptionConversionImpossible {
        String result = "";
        try {
            result = this.message;
        }
        catch (Exception e) {
            throw new ExceptionConversionImpossible("Conversion Impossible en chaine de caractère");
        }
        return result;
    }

    /**
     * Renvoie le message sous forme d’un entier
     * @return result : le message à envoyer
     */
    @Override
    public Integer asInteger() throws ExceptionConversionImpossible {
        int result = 0;
        try {
            result = Integer.parseInt(message);
        }
        catch (Exception e) {
            throw new ExceptionConversionImpossible("Conversion Impossible en entier");
        }
        return result;
    }

    /**
     * Permet de recuperer la liste des caractere du message en ascii
     * @return list : Renvoie la liste des codes ascii (int)
     * @throws ExceptionConversionImpossible
     */
    public ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible{

        //On crée notre liste qui va contenir les caractères ascii
        ArrayList<Integer> list = new ArrayList<Integer>();

        //On récupère le code ascii pour chaque lettre
        for(int i = 0;i < this.message.length();i++){

            //On met la lettre dans une variable
            char lettre = this.message.charAt(i);

            //On convertit la lettre en int -> code ascii
            int ascii = (int)lettre;

            //On l'ajoute à la liste
            list.add(ascii);
        }

        return list;
    }

}
