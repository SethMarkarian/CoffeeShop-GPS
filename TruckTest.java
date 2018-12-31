

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TruckTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TruckTest
{
    @Test
    public void testTruckCapacity() {
        Truck t = new Truck(new City("A"));
        int theAns = t.capacity;
        int trueAns = 500;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testTruckPosition() {
        Truck t = new Truck(new City("A"));
        String theAns = t.position.name;
        String trueAns = "A";
        assertEquals(theAns, trueAns);
    }
}