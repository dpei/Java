
/**
 * Filter depth for earthquake data
 * 
 * @author Dong Pei
 * @version Apr. 8. 2017
 */
public class DepthFilter implements Filter{
    private double depthMin;
    private double depthMax;
    public DepthFilter(double min, double max) { 
        depthMin = min;
        depthMax = max;
    }
    public boolean satisfy(QuakeEntry qe) { 
        return (qe.getDepth() >= depthMin && qe.getDepth() <= depthMax); 
    }   
    public String getName(){
        return "DepthFilter";
    }
}