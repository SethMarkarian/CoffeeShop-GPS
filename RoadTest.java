

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RoadTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RoadTest
{   
    @Test
    public void testNewRoad() {
        Road r = new Road(new City("A"), new City("B"), 3);
        int theAns = r.w;
        int trueAns = 3;
        assertEquals(theAns, trueAns);
    }
}
