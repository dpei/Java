
/**Modified method
 * Find N-closest quakes
 * 
 * @author Duke Software/Learn to Program
 * @modified by Dong Pei
 * @last modified: Apr. 8. 2017
 */

import java.util.*;

public class ClosestQuakes {
    public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, 
    int count) {
        ArrayList<QuakeEntry> sliced = quakeData;
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (int k=0; k<count; k++){
            int closeInd = 0;
            double closeDist = sliced.get(closeInd).getLocation().distanceTo(current);
            for (QuakeEntry entry : sliced){
                double currDist = entry.getLocation().distanceTo(current);
                if (currDist < closeDist){
                    closeInd = sliced.indexOf(entry);
                    closeDist = currDist;
                }
            }
            answer.add(sliced.get(closeInd));
            sliced.remove(closeInd);
        }
        return answer;
    }
    
    public void findClosestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());
        // set location
        Location jakarta  = new Location(-6.211,106.845);
        // find result
        ArrayList<QuakeEntry> close = getClosest(list,jakarta,10);
        for(int k=0; k < close.size(); k++){
            QuakeEntry entry = close.get(k);
            double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            //System.out.printf(entry.toString());
            // .2 means the float digit after decimal.
            System.out.printf("%3.2f\t %s\n", distanceInMeters/1000, entry);
        }
        System.out.println("number found: "+close.size());
    }
    
}
