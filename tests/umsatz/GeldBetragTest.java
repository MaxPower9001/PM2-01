package umsatz;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import umsatz.GeldBetrag;
import umsatz.UngueltigerGeldbetragException;


public class GeldBetragTest {

    @Test
    public void testToString() throws Exception, UngueltigerGeldbetragException{
        assertEquals("0,01€",new GeldBetrag(1).toString());
        assertEquals("1€",new GeldBetrag(100).toString());
        assertEquals("1,25€",new GeldBetrag(1,25).toString());
        assertEquals("4,45€",new GeldBetrag(1,345).toString());
        
    }

    @Test
    public void testAdd() throws Exception, UngueltigerGeldbetragException {
        assertEquals(new GeldBetrag(0,1),new GeldBetrag(1).add(new GeldBetrag(0)));
        assertEquals(new GeldBetrag(0,0),new GeldBetrag(0).add(new GeldBetrag(0)));
        assertEquals(new GeldBetrag(1,10),new GeldBetrag(1,5).add(new GeldBetrag(5)));
    }
    
    @Test
    public void testEquals() throws Exception, UngueltigerGeldbetragException {
    	// reflexiv
    	GeldBetrag g1 = new GeldBetrag(1);
    	assertEquals(g1,g1);
    	// symetrisch
    	GeldBetrag g2 = new GeldBetrag(1);
    	assertEquals(g1,g2);
    	assertEquals(g2,g1);
    	// transitiv
    	GeldBetrag g3 = new GeldBetrag(1);
    	assertEquals(g1,g2);
    	assertEquals(g2,g3);
    	assertEquals(g1,g3);
    	
    	assertNotEquals(g1,null);
    	assertNotEquals(g1, "string");
    	
    	List<GeldBetrag> lo = Arrays.asList(g1,g1);
    	assertEquals(true, lo.contains(g2));
        
    	
    }

}
