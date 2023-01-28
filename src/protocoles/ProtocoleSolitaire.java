package protocoles;

import entites.Personne;

public class ProtocoleSolitaire  implements Protocole{
    @Override
    public void executer() {
        //On crée Alice et Bob
        Personne alice = new Personne("Alice");
        
        Personne bob = new Personne("Bob");
    }
}
