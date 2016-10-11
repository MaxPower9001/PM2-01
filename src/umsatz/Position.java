package umsatz;

/**
 * Created by Rene on 03.10.2016.
 */
public class Position {
    private String name = "";
    private GeldBetrag  geldBetrag;

    public Position(String name, GeldBetrag geldBetrag) {
        this.name = name;
        this.geldBetrag = geldBetrag;
    }

    public GeldBetrag getGeldBetrag() {
        return geldBetrag;
    }

    public boolean equals(Position other){
        if(!other.name.equals(this.name)){
            return false;
        } else {
            return true;
        }
    }

    public String toString(){
        return name + " (" + geldBetrag.toString() + ")";
    }
}
