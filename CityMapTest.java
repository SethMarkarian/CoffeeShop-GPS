
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityMapTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CityMapTest
{
    @Test
    public void testSetCenter() {
        CityMap cityMap = new CityMap();
        cityMap.setCenter(new City("A"));
        String theAns = cityMap.center.name;
        String trueAns = "A";
        assertEquals(theAns, trueAns);
    }

    @Test
    public void testAddRoad() {
        CityMap cityMap = new CityMap();
        cityMap.addRoad("A", "B", 3);
        int theAns = cityMap.getCity("A").nbs.get(0).w;
        int trueAns = 3;
        assertEquals(theAns, trueAns);
    }

    @Test
    public void testGetCity() {
        CityMap cityMap = new CityMap();
        City c = cityMap.getCity("A");
        String theAns = c.name;
        String trueAns = "A";
        assertEquals(theAns, trueAns);
    }

    // @Test
    // public void testMoveTruck() {
        // CityMap cityMap = new CityMap();
        // cityMap.setCenter(new City("A"));
        // cityMap.addRoad("A", "B", 4);
        // cityMap.addRoad("C", "D", 8);
        // cityMap.addRoad("D", "A", 2);
        // Truck t = new Truck(cityMap.getCity("A"));
        // boolean theAns = cityMap.moveTruck(t);
        // boolean trueAns = false;
        // assertEquals(theAns, trueAns);
    // }
}
