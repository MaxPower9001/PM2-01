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
        d.add(a);
        d.add(a);
        d.add(a);
        d.add(a);
        d.add(b);
        d.add(c);
        e.add(a);
        e.add(a);
        e.add(a);
        f.add(c);
        f.add(c);
        f.add(c);

    }
    @Test
    public void TestAdd() throws Exception {
        Kasse k = new Kasse();
        k.add(d);
        k.add(e);
        k.add(f);
        System.out.println(k.toString());
    }

    @Test
    public void TestKassenStand() throws Exception {
        Kasse k = new Kasse();
        k.add(d);
        k.add(e);
        k.add(f);
        assertEquals("61€",k.kassenStand().toString());
    }

    @Test
    public void TestSummePosition() throws Exception {
        Kasse k = new Kasse();
        k.add(d);
        k.add(e);
        k.add(f);
        assertEquals("20€",k.summePosition(c).toString());

    }

    @Test
    public void TestToString() throws Exception {

    }

}