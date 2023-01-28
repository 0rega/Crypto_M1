package donnees.cles;

import exceptions.ExceptionConversionImpossible;

public class CleString implements Cle {
    private String cle;

    public CleString(String chaine){
        this.cle = chaine;
    }

    /**
     * Donne la clé sous forme de chaine de caractère
     * @return la clé sous forme de chaine de caractère
     * @throws ExceptionConversionImpossible
     */
    @Override
    public String asString() throws ExceptionConversionImpossible {
        String res = "";

        try{
            res = this.cle;
        }
        catch(Exception e){
            throw new ExceptionConversionImpossible("Conversion Impossible en chaine de caractères");
        }

        return res;
    }

    /**
     * Donne la forme entière de la clé mais renvoie une exception car c'est sous la forme d'une chaine de caractère
     * @return ne renvoie rien car il y aura une exception
     * @throws ExceptionConversionImpossible l'exception renvoyé pour dire que la conversion est impossible
     */
    @Override
    public int asInteger() throws ExceptionConversionImpossible {
        throw new ExceptionConversionImpossible("Conversion Impossible en entier");
    }

}

