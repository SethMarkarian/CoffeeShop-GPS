
/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class Shipment
{
    protected ArrayList<Cargo> s = new ArrayList<Cargo>();
    protected int weight = 0;

    /**
     * Adds cargo to the shipment
     * @param cargo Cargo to be added
     */
    public void addCargo(Cargo cargo){
        s.add(cargo);
        weight += cargo.weight;
    }
}
