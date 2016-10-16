package umsatz;
import org.junit.Before;
import org.junit.Test;
import umsatz.GeldBetrag;
import umsatz.Position;
import umsatz.Rechnung;
import umsatz.UngueltigerGeldbetragException;

import static org.junit.Assert.*;

/**
 * Created by Rene on 03.10.2016.
 */
public class RechnungTest {
    private Position a,a1,a2;
    private Position b;
    private Position c;

    @Before
    public void setUp() throws Exception, UngueltigerGeldbetragException {
        a = new Position("Hackfleischbraten", new GeldBetrag(500));
        a1 = new Position("Hackfleischbraten", new GeldBetrag(500));
        a2 = new Position("Braten", new GeldBetrag(500));
        b = new Position("Hackfleischbraten", new GeldBetrag(600));
        c = new Position("Hackfleischbraten mit Zwiebeln", new GeldBetrag(500));
    }

    @Test
    public void TestAdd() throws Exception {
        Rechnung rechnung = new Rechnung(1337);
        rechnung.add(a);
        rechnung.add(b);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        assertEquals(10,rechnung.getPositionenCount());
    }

    @Test
    public void TestRechnungsSumme() throws Exception, UngueltigerGeldbetragException {
        Rechnung rechnung = new Rechnung(1337);
        rechnung.add(a);
        rechnung.add(b);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        assertEquals(new GeldBetrag(56,0),rechnung.rechnungsSumme());
    }

    @Test
    public void TestSummePosition() throws Exception, UngueltigerGeldbetragException {
        Rechnung rechnung = new Rechnung(1337);
        rechnung.add(a);
        rechnung.add(b);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        assertEquals(new GeldBetrag(11,0),rechnung.summePosition(a1));
        assertEquals(new GeldBetrag(0,0),rechnung.summePosition(a2));
    }

    @Test
    public void TestToString() throws Exception {
        Rechnung rechnung = new Rechnung(1337);
        rechnung.add(a);
        rechnung.add(b);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
        rechnung.add(c);
    }

}