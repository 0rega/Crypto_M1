package entites;

import donnees.cles.Cles;
import donnees.messages.Message;

import java.util.HashMap;

public class Univers {
    private HashMap<String, Cles> listeClesPubliques;
    private HashMap<String, Message> listeMessagesPublics;
    private static Univers instance = new Univers();

    private Univers() {
        this.listeClesPubliques = new HashMap<String, Cles>();
        this.listeMessagesPublics = new HashMap<String, Message>();
    }

    /**
     * Permet d'obtenir l'instance de la classe
     * @return l'instance de la classe
     */
    public static Univers get() {
        return instance;
    }

    /**
     * Ajoute les clés dans la liste des cles publiques de notre Univers
     * @param identifiant identifiant qui permet de representer les clés
     * @param cles les cles à ajouter
     */
    public static void addCles(String identifiant, Cles cles) {
        instance.listeClesPubliques.put(identifiant, cles);
    }

    /**
     * Permet d'obtenir les cles publiques de notre Univers
     * @param identifiant identifiant des clés cherchés
     * @return le message qu'on veut obtenir
     */
    public static Cles getCles(String identifiant) {
        return instance.listeClesPubliques.get(identifiant);
    }

    /**
     * Ajoute les messages dans la liste des messages publiques de notre Univers
     * @param identifiant identifiant qui permet de representer le message
     * @param message le message qu'on veut ajouter
     */
    public static void addMessage(String identifiant, Message message) {
        instance.listeMessagesPublics.put(identifiant, message);
    }

    /**
     * Permet d'obtenir les messages publiques de notre Univers
     * @param identifiant identifiant du message cherché
     * @return le message qu'on veut obtenir
     */
    public static Message getMessage(String identifiant) {
        return instance.listeMessagesPublics.get(identifiant);
    }
}