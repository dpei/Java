
/**
 * filter magnititude data within a specific range.
 * 
 * @author Dong Pei
 * @version (a version number or a date)
 */
public class MagFilter implements Filter{
    private double magMin;
    private double magMax;
    public MagFilter(double min, double max) { 
        magMin = min;
        magMax = max;
    }
    public boolean satisfy(QuakeEntry qe) { 
        return (qe.getMagnitude() >= magMin && qe.getMagnitude() <= magMax); 
    } 
    public String getName(){
        return "MagFilter";
    }
}
