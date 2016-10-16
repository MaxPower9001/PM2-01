package umsatz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rene on 03.10.2016.
 */
public class KasseTest {
    Position a;
    Position b;
    Position c;
    Rechnung d;
    Rechnung e;
    Rechnung f;

    @Before
    public void setUp() throws Exception, UngueltigerGeldbetragException {
        a = new Position("Hackfleischbraten", new GeldBetrag(500));
        b = new Position("Hackfleischbraten", new GeldBetrag(600));
        c = new Position("Hackfleischbraten mit Zwiebeln", new GeldBetrag(500));
        d = new Rechnung(1337);
        e = new Rechnung(4711);
        f = new Rechnung(42);
        
        d.add(a); // 5€
        d.add(b); // 6€
        d.add(c); // 5€
        d.add(a); // 5€
        e.add(a); // 5€
        e.add(b); // 6€
        e.add(b); // 6€
        e.add(b); // 6€
        f.add(a); // 5€
        f.add(a); // 5€
        f.add(a); // 5€
        f.add(a); // 5€
        f.add(a); // 5€
        f.add(a); // 5€
        f.add(a); // 5€
        //   Summe: 79€
        
        

    }
    @Test
    public void TestAdd() throws Exception {
        Kasse k = new Kasse();
        k.add(d);
        k.add(e);
        k.add(f);
        k.add(f);
        k.add(f);
        k.add(f);
        k.add(f);
        assertEquals(k.getRechnungCount(),7);
    }

    @Test
    public void TestKassenStand() throws Exception, UngueltigerGeldbetragException {
        Kasse k = new Kasse();
        k.add(d);
        k.add(e);
        k.add(f);
        assertEquals(new GeldBetrag(79,0),k.kassenStand());
    }

    @Test
    public void TestSummePosition() throws Exception, UngueltigerGeldbetragException {
        Kasse k = new Kasse();
        k.add(d);
        k.add(e);
        k.add(f);
        assertEquals(new GeldBetrag(5,0),k.summePosition(c));

    }

    @Test
    public void TestToString() throws Exception {

    }

}