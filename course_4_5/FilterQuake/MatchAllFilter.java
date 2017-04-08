
/**
 * Store and adapt all filters 
 * 
 * @author Dong Pei
 * @version Apr. 8. 2017
 */

import java.util.*;
public class MatchAllFilter implements Filter{
    private ArrayList<Filter> filters;
    public MatchAllFilter (){   
        filters = new ArrayList<Filter>();
    }
    public void addFilter(Filter f){
        filters.add(f);
    }
    public boolean satisfy(QuakeEntry qe){
        for (Filter f : filters){
            if(!f.satisfy(qe)){
                return false;
            }
        }
        return true;
    }
    public String getName(){
        StringBuilder sb = new StringBuilder("Filters used are: ");
        for (Filter f : filters){
            sb.append(f.getName()+" ");
        }
        return sb.toString();
    }
}
