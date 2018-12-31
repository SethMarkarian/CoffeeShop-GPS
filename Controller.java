
/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import java.util.*;

public class Controller
{
    private CityMap map = new CityMap();
    private int numRoads;
    private int numWarehouses;
    private City center;
    private int totalCargos;

    public static void main(String args[]){
        Controller c = new Controller();
        c.readRoads();
        c.readWarehouses();
        c.readCenter();
        c.run();
    }

    /**
     * Simulates delivery of all packages
     */
    private void run() {
        try{
            FileWriter fr = new FileWriter("resultsToCompare/out.txt");
            map.setCenter(center);
            map.getReturnRoutes();
            int total = 0;
            int i = 0;
            while(totalCargos > 0) {
                fr.write("Truck " + (i + 1) + ":\n");
                Truck t = new Truck(center);
                while(map.moveTruck(t, fr) == true);
                t.distanceTraveled += t.position.distToCenter;
                total += t.distanceTraveled;
                totalCargos -= t.shipment.s.size();
                fr.write("Distance traveled " + t.distanceTraveled + "\n");
                i++;
            }
            fr.write("Total distance traveled: " + total);
            fr.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }

    }

    /**
     * Reads the center
     */
    private void readCenter(){
        try{
            Scanner in = new Scanner(new FileReader("data2/center.txt"));
            center = map.getCity(in.nextLine());
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Reads the warehosues and associates them with a City
     */
    private void readWarehouses(){
        try{
            Scanner in = new Scanner(new FileReader("data2/warehouses.txt"));
            numWarehouses = Integer.parseInt(in.nextLine());

            //Creates warehouses w/ cargo and allocates them to a city
            while (in.hasNextLine()) {
                String[] line = in.nextLine().split(" ");
                Cargo[] cargo = new Cargo[line.length - 1];
                totalCargos += cargo.length;
                for(int i = 1; i < line.length; i++){
                    cargo[i - 1] = new Cargo((i - 1), Integer.parseInt(line[i]));
                }
                Warehouse w = new Warehouse(cargo);
                map.getCity(line[0]).warehouse = w;
                w.city = map.getCity(line[0]);
            }
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Reads the cities/roads and creates a CityMap
     */
    private void readRoads(){
        try{
            Scanner in = new Scanner(new FileReader("data2/roads.txt"));
            numRoads = Integer.parseInt(in.nextLine());

            while (in.hasNextLine()) {
                String[] line = in.nextLine().split(" ");
                int w = Integer.parseInt(line[2]);
                map.addRoad(line[0], line[1], w);
            }
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }

    }
}
