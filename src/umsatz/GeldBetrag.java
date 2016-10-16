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
        if(centBetrag < 0 || euroBetrag < 0) {
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
        	// wird nie erreichtr
        }
        return returnGeldBetrag;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + betrag;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		GeldBetrag other = (GeldBetrag) obj;
		if (betrag != other.betrag)
			return false;
		return true;
	}
    
    
}
