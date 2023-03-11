import protocoles.Protocole;
import protocoles.ProtocoleSolitaire;

public class Main {
    public static void main(String[] args) {
        System.out.println("Algorithme Solitaire");
        Protocole protoS = new ProtocoleSolitaire();
        protoS.executer();

    }
}