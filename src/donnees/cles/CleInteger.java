package donnees.cles;

import exceptions.ExceptionConversionImpossible;

public class CleInteger implements Cle{
    private int cle;

    public CleInteger(int cle){
        this.cle = cle;
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
            res = Integer.toString(this.cle);
        }
        catch(Exception e){
            throw new ExceptionConversionImpossible("Conversion Impossible en chaine de caractères");
        }

        return res;
    }

    /**
     * Donne la forme entière de la clé
     * @return la clé sous forme d'entier
     * @throws ExceptionConversionImpossible
     */
    @Override
    public int asInteger() throws ExceptionConversionImpossible {
        int res = 0;

        try{
            res = this.cle;
        }
        catch(Exception e){
            throw new ExceptionConversionImpossible("Conversion Impossible en entier");
        }

        return res;
    }
}