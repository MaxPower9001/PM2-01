package umsatz;

import java.util.Arrays;

/**
 * Created by Rene on 03.10.2016.
 */
public class Kasse {

    private final int _initialeKapazitaet = 5;
    private final int _erweiternUm = 2;

    private int cursor = 0;

    private Rechnung[] rechnungen;

    public Kasse() {
        this.rechnungen = new Rechnung[_initialeKapazitaet];
    }

    public void add(Rechnung rechnung){

        if(cursor < rechnungen.length){
            rechnungen[cursor] = rechnung;
            cursor++;
        } else {
            rechnungen = Arrays.copyOf(rechnungen,rechnungen.length + _erweiternUm);
            add(rechnung);
        }

    }

    public GeldBetrag kassenStand() {
        GeldBetrag returnGeldBetrag = new GeldBetrag();

        for (Rechnung rechnung : getRechnungen()) {
            returnGeldBetrag = returnGeldBetrag.add(rechnung.rechnungsSumme());
        }

        return returnGeldBetrag;
    }

    public GeldBetrag summePosition(Position pos) {
        GeldBetrag returnGeldBetrag = new GeldBetrag();

        for (Rechnung rechnung : getRechnungen()) {
            for (Position position : rechnung.getPositionen()) {
                if(position.equals(pos)){
                    returnGeldBetrag = returnGeldBetrag.add(position.getGeldBetrag());
                }
            }
        }

        return returnGeldBetrag;
    }

    @Override
    public String toString(){
        String returnString = "";

        for (Rechnung rechnung : getRechnungen()) {
            returnString += rechnung.toString() + "\n\n\n";
        }

        return returnString;
    }

    public Rechnung[] getRechnungen() {
        return Arrays.copyOf(rechnungen,cursor);
    }
}


