package umsatz;

import java.util.Arrays;
import java.util.List;

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
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geldBetrag == null) ? 0 : geldBetrag.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj.getClass()!=(obj.getClass()))
			return false;
		Position other = (Position) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString(){
        return name + " (" + geldBetrag.toString() + ")";
    }
    
//    public static void main(String[] args) {
//		Position p1 = new Position("n1", new GeldBetrag());
//		Position p2 = new Position("n1", new GeldBetrag());
//		List<Position> lo = Arrays.asList(p1,p1);
//		
//		System.out.println(lo.contains(p2));
//	}
}
