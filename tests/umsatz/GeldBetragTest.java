package umsatz;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import umsatz.GeldBetrag;
import umsatz.Position;
import umsatz.UngueltigerGeldbetragException;


public class GeldBetragTest {

    @Test
    public void testToString() throws Exception, UngueltigerGeldbetragException{
        assertEquals("0,01€",new GeldBetrag(1).toString());
        assertEquals("1€",new GeldBetrag(100).toString());
        assertEquals("1,25€",new GeldBetrag(1,25).toString());
    }

    @Test
    public void testAdd() throws Exception, UngueltigerGeldbetragException {
        assertEquals("0,01€",new GeldBetrag(1).add(new GeldBetrag(0)).toString());
        assertEquals("0€",new GeldBetrag(0).add(new GeldBetrag(0)).toString());
        assertEquals("1,10€",new GeldBetrag(1,5).add(new GeldBetrag(5)).toString());
    }

}
