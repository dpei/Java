
/**
 * Design filters for filtering different creteria within the earthquake data
 * 
 * @author  Duke team
 */
public interface Filter
{
    public  boolean satisfy(QuakeEntry qe); 
    public String getName();
}