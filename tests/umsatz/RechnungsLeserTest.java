package umsatz;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class RechnungsLeserTest {

	@Test
	public void test() throws FileNotFoundException, UngueltigerGeldbetragException {
		RechnungsLeser rc = new RechnungsLeser("rechnungen.sv");
		Kasse kasseAusDatei = rc.leseKasse();
		Rechnung rechnungReferenz = new Rechnung(1);
		rechnungReferenz.add(new Position("Vitello tonnato", new GeldBetrag(15 * 100)));
		rechnungReferenz.add(new Position("Antipasto misto", new GeldBetrag(15 * 100)));
		rechnungReferenz.add(new Position("Riso col nero di seppie", new GeldBetrag(16 * 100)));
		rechnungReferenz.add(new Position("Ossobuco", new GeldBetrag(25 * 100)));
		rechnungReferenz.add(new Position("Panna cotta", new GeldBetrag(7 * 100)));
		rechnungReferenz.add(new Position("Aqua", new GeldBetrag(10 * 100)));
		rechnungReferenz.add(new Position("Te nero", new GeldBetrag(4 * 100)));
		rechnungReferenz.add(new Position("Spuma", new GeldBetrag(4 * 100)));
		System.out.println("Kasse:         "+ kasseAusDatei);
		System.out.println("1. Rechnung Referenz: " +rechnungReferenz);
	}

}
