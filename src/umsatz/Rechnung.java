package umsatz;

import java.util.Arrays;

/**
 * Created by Rene on 03.10.2016.
 */
public class Rechnung {

	private final int _initialeKapazitaet = 5;
	private final int _erweiternUm = 2;

	private int cursor = 0;

	private int rechnungsNummer;

	private Position[] positionen;

	public Rechnung(int rechnungsNummer) {
		this.positionen = new Position[_initialeKapazitaet];
		this.rechnungsNummer = rechnungsNummer;
	}

	public void add(Position position) {

		if (cursor >= positionen.length) {
			positionen = Arrays.copyOf(positionen, positionen.length + _erweiternUm);
		}
		positionen[cursor] = position;
		cursor++;

	}

	public GeldBetrag rechnungsSumme() {
		GeldBetrag returnGeldBetrag = new GeldBetrag();

		for (Position position : getPositionen()) {
			returnGeldBetrag = returnGeldBetrag.add(position.getGeldBetrag());
		}

		return returnGeldBetrag;
	}

	public GeldBetrag summePosition(Position pos) {
		GeldBetrag returnGeldBetrag = new GeldBetrag();

		for (Position position : getPositionen()) {
			if (position.equals(pos)) {
				returnGeldBetrag = returnGeldBetrag.add(position.getGeldBetrag());
			}
		}

		return returnGeldBetrag;
	}

	@Override
	public String toString() {
		return "Rechnung:" + rechnungsNummer +":" + Arrays.toString(getPositionen());
	}

	private Position[] getPositionen() {
		return Arrays.copyOf(positionen, cursor);
	}
	
	public int getPositionenCount()
	{
		return getPositionen().length;
	}
}
