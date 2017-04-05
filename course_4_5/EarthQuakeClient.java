/**This class was modified from Duke program team.
 * 
 * modified by@: Dong Pei
 * last modified@ Apr. 4. 2017
 * 
 * 
 */

import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry entry : quakeData){
            if (entry.getMagnitude() > magMin){
                answer.add(entry);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax, Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry entry : quakeData){
            if (entry.getLocation().distanceTo(from) < distMax){
                answer.add(entry);
            }
        }
        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> answer =  filterByMagnitude(list, 5.0);
        for (QuakeEntry entry : answer){
            System.out.println(entry);
        }
        System.out.println("Found"+answer.size()+" quakes that match that criteria");
    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        
        // This location is Durham, NC
        Location city = new Location(35.988, -78.907);
        ArrayList<QuakeEntry> answer = filterByDistanceFrom(list, 1000*1000, city);
        System.out.println("A total of "+answer.size()+ 
                            "quakes that next to Durham, NC within 1000km");
        // This location is Bridgeport, CA
        city =  new Location(38.17, -118.82);
        filterByDistanceFrom(list, 1000, city);
        answer = filterByDistanceFrom(list, 1000*1000, city);
        System.out.println("A total of "+answer.size()+ 
                            " quakes that next to Bridgeport, CA within 1000km");
        for (QuakeEntry entry : answer){
            System.out.println(entry.getLocation().distanceTo(city)/1000+"\t"+entry.getInfo());
        }
        
        
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
