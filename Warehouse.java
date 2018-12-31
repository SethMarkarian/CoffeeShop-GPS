
/**
 * Write a description of class Warehouse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class Warehouse
{
    protected PriorityQueue<Cargo> cargoRequest = new PriorityQueue<Cargo>();
    protected City city;
    
    public Warehouse(Cargo[] ca){
        for(int i = 0; i < ca.length; i++){
            cargoRequest.add(ca[i]);
        }
    }
}
