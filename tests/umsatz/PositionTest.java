package umsatz;
import org.junit.Before;
import org.junit.Test;
import umsatz.GeldBetrag;
import umsatz.Position;
import umsatz.UngueltigerGeldbetragException;

import static org.junit.Assert.*;

/**
 * Created by Rene on 03.10.2016.
 */
public class PositionTest {
    Position a;
    Position b;
    Position c;

    @Before
    public void setUp() throws Exception, UngueltigerGeldbetragException {
        a = new Position("Hackfleischbraten", new GeldBetrag(500));
        b = new Position("Hackfleischbraten", new GeldBetrag(600));
        c = new Position("Hackfleischbraten mit Zwiebeln", new GeldBetrag(500));
    }

    @Test
    public void testEquals() throws Exception {
        assertEquals(true, a.equals(b));
        assertEquals(false, a.equals(c));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Hackfleischbraten (5€)",a.toString());
        assertEquals("Hackfleischbraten (6€)",b.toString());
        assertEquals("Hackfleischbraten mit Zwiebeln (5€)",c.toString());
    }

}