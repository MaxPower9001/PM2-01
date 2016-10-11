package umsatz;

/**
 * Created by Rene on 03.10.2016.
 */
public class GeldBetrag {

    private int betrag;

    public GeldBetrag(){
        this.betrag = 0;
    }

    public GeldBetrag(int centBetrag) throws UngueltigerGeldbetragException {
        if(centBetrag < 0){
            throw new UngueltigerGeldbetragException();
        } else {
            this.betrag = centBetrag;
        }
    }

    public GeldBetrag(int euroBetrag, int centBetrag) throws UngueltigerGeldbetragException {
        this(euroBetrag * 100 + centBetrag);
        if(centBetrag < 0 || centBetrag > 99 || euroBetrag < 0) {
            throw new UngueltigerGeldbetragException();
        }
    }

    @Override
    public String toString(){
        String returnString = "";
        if(betrag % 100 == 0){
            returnString = String.valueOf(betrag/100);
        }
        else {
            int hundert = betrag/100;
            int zehner  = (betrag - hundert*100) / 10;
            int einer   = betrag % 10;

            returnString = hundert + "," + zehner + einer;
        }
        return returnString + "€";
    }

    public GeldBetrag add(GeldBetrag geldBetrag) {
        GeldBetrag returnGeldBetrag = null;
        try {
             returnGeldBetrag = new GeldBetrag(geldBetrag.betrag + this.betrag);
        } catch (UngueltigerGeldbetragException e) {
            // Holy moly hold your horses if this ever happens
            e.printStackTrace();
        }
        return returnGeldBetrag;
    }
}
