package umsatz;
import org.junit.Before;
import org.junit.Test;
import umsatz.GeldBetrag;
import umsatz.Position;
import umsatz.UngueltigerGeldbetragException;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

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
    public void testEquals() throws Exception, UngueltigerGeldbetragException {
        assertEquals(true, a.equals(b));
        assertEquals(false, a.equals(c));
        
        
     // reflexiv
    	Position p1 = new Position("Pizza Tonno", new GeldBetrag(500));
    	assertEquals(p1,p1);
    	// symetrisch
    	Position p2 = new Position("Pizza Tonno", new GeldBetrag(800));
    	assertEquals(p1,p2);
    	assertEquals(p2,p1);
    	// transitiv
    	Position p3 = new Position("Pizza Tonno", new GeldBetrag(1200));
    	assertEquals(p1,p2);
    	assertEquals(p2,p3);
    	assertEquals(p1,p3);
    	
    	assertNotEquals(p1,null);
    	assertNotEquals(p1, "string");
    	assertNotEquals(p1, new Position("Pizza Calzone", new GeldBetrag(500)));
    	
    	List<Position> lo = Arrays.asList(p1,p1);
    	assertEquals(true, lo.contains(p2));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Hackfleischbraten (5€)",a.toString());
        assertEquals("Hackfleischbraten (6€)",b.toString());
        assertEquals("Hackfleischbraten mit Zwiebeln (5€)",c.toString());
    }

}