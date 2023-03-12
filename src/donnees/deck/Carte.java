package donnees.deck;

public class Carte {

    private String symbole;
    private int value;

    public Carte(String s, Integer v){
        symbole = s;
        value = v;
    }

    public String getSymbole(){
        return symbole;
    }

    public int getValue(){
        return value;
    }

    public void setSymbole(String symbole){
        this.symbole = symbole;
    }

    public void setValue(int value){
        this.value = value;
    }

    public String toString(){
        return this.value + "-" + this.symbole;
    }

    public int getCount(){
        int count = 0;
        switch (this.getSymbole()){
            case "TREFLE":
                count = this.getValue();
                break;
            case "CARREAU":
                count = this.getValue() + 13;
                break;
            case "COEUR":
                count = this.getValue() + 26;
                break;
            case "PIQUE":
                count = this.getValue() + 39;
                break;
            case "JOKER":
                count = 53;
                break;
        }
        return count;
    }
}