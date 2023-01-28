package exceptions;

public abstract class ExceptionCryptographie extends Exception{
    private String nom;
    private String message;

    public ExceptionCryptographie(String m, String n){
        this.nom = n;
        this.message = m;
    }

    /**
     * Gere le message d'erreur en affichant le message d'erreur
     */
    public void gerer(){
        //Message d'erreur
        System.err.println(this.nom + " : " + this.message);

        this.printStackTrace(System.err);
    }
}