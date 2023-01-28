package donnees.cles;

import java.util.HashMap;

public class Cles {
    private HashMap<String,Cle> listeCles;

    public Cles(){
        listeCles = new HashMap<String,Cle>();
    }

    /**
     * Permet d'obtenir une clé dans les clés
     * @param nom nom de la clé
     * @return la clé correspondant au nom
     */
    public Cle getCle(String nom){

        return listeCles.get(nom);
    }

    /**
     * Permet d'ajouter une clé dans les clés
     * @param nom nom de la clé
     * @param cle la clé à ajouter
     */
    public void addCle(String nom, Cle cle){

        this.listeCles.put(nom, cle);
    }

}