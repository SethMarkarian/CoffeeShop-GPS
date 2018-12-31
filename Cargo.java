
/**
 * Write a description of class Cargo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cargo implements Comparable<Cargo>
{
    protected int id;
    protected int weight;
    protected Warehouse warehouse;
    
    public Cargo(int i, int w){
        id = i + 1;
        weight = w;
    }
    
    @Override
    public int compareTo(Cargo c){
        if(this.weight < c.weight){
            return -1;
        }
        else if(this.weight > c.weight){
            return 1;
        }
        else if(this.weight == c.weight) {
            return 0;
        }
        else{
            return 0;
        }  
    }
}
