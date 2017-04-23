
/**
 * New comparator for comparing title info and depth info in quakeData.
 * Compare title info first, then compare depth when title is tie
 * 
 * @author Dong Pei
 * @created Apr. 10. 2017
 */

import java.util.*;

public class TitleAndDepthComparator implements Comparator<QuakeEntry>{
    // The compare() method within each Comparator defines precisely what sored order means.
    
    public int compare(QuakeEntry qe1, QuakeEntry qe2){
        if (qe1.getInfo() != qe2.getInfo()){
            return qe1.getInfo().compareTo(qe2.getInfo());
        } 
        if (qe1.getDepth() != qe2.getDepth()) {
            return Double.compare(qe1.getDepth(), qe2.getDepth());
        } else {
            return 0;
        }
        
        
    }
}
