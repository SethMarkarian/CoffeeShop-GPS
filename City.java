
/**
 * Write a description of class City here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

class City implements Comparable<City> {
    protected String name;
    protected List<Road> nbs = new ArrayList<Road>();
    protected int dist = Integer.MAX_VALUE;
    protected int distToCenter = Integer.MAX_VALUE;
    protected boolean visited = false;
    protected Warehouse warehouse = null;

    public City(String n) {
        name = n;
    }
    
    public City(String n, Warehouse w){
        name = n;
        warehouse = w;
    }

    /**
     * Compares one city with another
     * @param v City to be compared with
     * @return Returns 1 if v is closer, -1 if v is farther. If they are the same distance, the city with the alphabetically first name is farther.
     */
    @Override
    public int compareTo(City v) {
        if(dist < v.dist){
            return -1;
        }else if(dist > v.dist){
            return 1;
        }else{
            return(name.compareTo(v.name));
        }
    }
}
