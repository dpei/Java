
/**
 * Filter the earthquake data with a specific distance to one location
 * 
 * @author Dong Pei
 * @version Apr. 8. 2017
 */
public class DistanceFilter implements Filter{
    private double distance; 
    private Location from;
    public DistanceFilter (double dis, Location spot) { 
        distance = dis;
        from = spot;
    }
    public boolean satisfy(QuakeEntry qe) { 
        return (qe.getLocation().distanceTo(from) < distance); 
    }
    public String getName(){
        return "DistanceFilter";
    }    
}