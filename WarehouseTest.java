

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WarehouseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WarehouseTest
{
    @Test
    public void testWarehouseCargoRequest() {
        Cargo[] c = {new Cargo(1, 2), new Cargo(2, 3), new Cargo(3, 4)};
        Warehouse w = new Warehouse(c);
        int theAns = w.cargoRequest.size();
        int trueAns = 3;
        assertEquals(trueAns, theAns);
    }
}
