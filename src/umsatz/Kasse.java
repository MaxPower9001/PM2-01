package umsatz;

import java.util.Arrays;

/**
 * Created by Hubert and Herbert on 03.10.2016.
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
        	returnGeldBetrag = returnGeldBetrag.add(rechnung.summePosition(pos));
        }

        return returnGeldBetrag;
    }

    @Override
    public String toString(){
        return "Kasse:" + Arrays.toString(getRechnungen());
    }

    private Rechnung[] getRechnungen() {
        return Arrays.copyOf(rechnungen,cursor);
    }
    
    public int getRechnungCount()
    {
    	return getRechnungen().length;
    }
}


