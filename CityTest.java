
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CityTest
{
    @Test
    public void testCityCompare() {
        City a = new City("A");
        City b = new City("B");
        a.dist = 5;
        b.dist = 3;
        int theAns = a.compareTo(b);
        int trueAns = 1;
        assertEquals(theAns, trueAns);
    }

    @Test
    public void testCityName() {
        City a = new City("A");
        String theAns = a.name;
        String trueAns = "A";
        assertEquals(theAns, trueAns);
    }
}
