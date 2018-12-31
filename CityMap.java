
/**
 * Write a description of class Graph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;

public class CityMap {
    protected Map<String, City> CityMap = new HashMap<String, City>(); 
    protected City center;

    /**
     * Sets the center
     * @param c A City to be set as the center.
     */
    public void setCenter(City c) {
        center = c;
    }

    /**
     * Creates a new road
     * @param start A City to start at, end A City to end at, w The length of the road
     */
    public void addRoad(String start, String end, int w) {
        City u = getCity(start);
        City v = getCity(end);
        u.nbs.add(new Road(u, v, w));
        v.nbs.add(new Road(v, u, w));
    }

    /** 
     * Retrieves City associated with the given name
     * @param name The name of the City to be retrieved
     * @return The City object
     */
    public City getCity(String name) {
        City v = CityMap.get(name);
        if (v == null) {
            v = new City(name);
            CityMap.put(name, v);
        }
        return v;
    }

    /**
     * Resets the distance and visited property of all cities
     **/
    private void reset() {
        for (City v: CityMap.values()) {
            v.dist = Integer.MAX_VALUE;
            v.visited = false;
        }
    }

    /**
     * Moves a truck from one city to the next closest city that has carriable cargo
     * @param t The truck
     * @return Whether or not the tuck found carriable cargo
     */
    public boolean moveTruck(Truck t, FileWriter fr) {
        try{
            reset();
            PriorityQueue<City> q = new PriorityQueue<City>();
            q.add(t.position);
            t.position.dist = 0;
            int currDist = 0;
            int tWeight = 0;

            while (!q.isEmpty()) {
                City u = q.poll();
                if (u.visited) continue;
                u.visited = true;
                for (Road e: u.nbs) {
                    City v = e.v;
                    if (v.dist > u.dist + e.w) {
                        q.remove(v);
                        v.dist = u.dist + e.w;
                        q.add(v);
                    }
                }
                if((u.warehouse != null) && (u.warehouse.cargoRequest.peek() != null) && (u.warehouse.cargoRequest.peek().weight + t.shipment.weight) <= t.capacity) { //before going back = 51
                    ArrayList<Cargo> tCargo = new ArrayList<Cargo>();
                    while(((u.warehouse.cargoRequest.peek() != null) && (u.warehouse.cargoRequest.peek().weight + t.shipment.weight) <= t.capacity)){
                        tWeight += u.warehouse.cargoRequest.peek().weight;
                        tCargo.add(u.warehouse.cargoRequest.peek());
                        t.shipment.addCargo(u.warehouse.cargoRequest.poll());
                    }
                    t.position = u;
                    currDist = u.dist;
                    fr.write("Deliver to warehouse " + t.position.name + " total weight: " + tWeight + " ([");
                    fr.write(u.name + "(" + tCargo.get(0).id + "): " + tCargo.get(0).weight);
                    for(int i = 1; i < tCargo.size(); i++){
                        fr.write(", " + u.name + "(" + tCargo.get(i).id + "): " + tCargo.get(i).weight);
                    }
                    fr.write("]) dist: " + currDist + "\n");
                    t.distanceTraveled += currDist;
                    return true;
                }
            }
            return false;
        }catch(Exception e){
            System.out.println("Exception: " + e);
            return false;
        }
    }

    /**
     * Finds the shortest path from the center to each other City
     **/
    public void getReturnRoutes() {
        reset();
        PriorityQueue<City> p = new PriorityQueue<City>();
        p.add(center);
        center.dist = 0;
        while (!p.isEmpty()) {
            City u = p.poll();
            if (u.visited) continue;
            u.visited = true;
            for(Road e: u.nbs) {
                City v = e.v;
                if(v.dist > u.dist + e.w) {
                    p.remove(v);
                    v.dist = u.dist + e.w;
                    v.distToCenter = v.dist;
                    p.add(v);
                }
            }
        }
    }
}   
