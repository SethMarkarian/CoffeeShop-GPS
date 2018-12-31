
/**
 * Write a description of class Truck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class Truck
{
    protected int capacity = 500;
    protected int distanceTraveled = 0;
    protected Shipment shipment = new Shipment();
    protected City position;
    
    public Truck(City c){
        position = c;
    }
}
