

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ShipmentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ShipmentTest
{
    @Test
    public void testAddCargo() {
        Cargo a = new Cargo(4, 5);
        Cargo b = new Cargo(3, 4);
        Cargo c = new Cargo(1, 2);
        Shipment shipment = new Shipment();
        shipment.addCargo(a);
        shipment.addCargo(b);
        shipment.addCargo(c);
        int theAns = shipment.s.size();
        int trueAns = 3;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testTotalCargoWeight() {
        Cargo a = new Cargo(4, 5);
        Cargo b = new Cargo(3, 4);
        Cargo c = new Cargo(1, 2);
        Shipment shipment = new Shipment();
        shipment.addCargo(a);
        shipment.addCargo(b);
        shipment.addCargo(c);
        int theAns = shipment.weight;
        int trueAns = 11;
        assertEquals(theAns, trueAns);
    }
}