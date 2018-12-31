

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CargoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CargoTest
{
    @Test
    public void testCargoWeight() {
        Cargo a = new Cargo(3, 4);
        int theAns = a.weight;
        int trueAns = 4;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testCargoID() {
        Cargo a = new Cargo(3, 4);
        int theAns = a.id;
        int trueAns = 4;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testCargoCompareTo() {
        Cargo a = new Cargo(3, 4);
        Cargo b = new Cargo(1, 2);
        int theAns = a.compareTo(b);
        int trueAns = 1;
        assertEquals(trueAns, theAns);
    }
}
