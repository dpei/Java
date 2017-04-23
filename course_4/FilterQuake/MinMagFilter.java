
/**
 * Use the class to filter earthquakes that has less magnitude than magMin.
 * 
 * @author Duke team
 */
public class MinMagFilter implements Filter
{
    private double magMin; 
    
    public MinMagFilter(double min) { 
        magMin = min;
    } 

    public boolean satisfy(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    } 
    public String getName(){
        return "MinMagFilter";
    }
}
