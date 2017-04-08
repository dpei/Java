import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfy(qe)) { 
                answer.add(qe); 
            } 
        }
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        // Filter f = new MinMagFilter(4.0);
        Filter f = new MagFilter(4.0, 5.0);
        ArrayList<QuakeEntry> m1  = filter(list, f); 
        f = new DepthFilter(-35000.0, -12000.0);
        ArrayList<QuakeEntry> m2 = filter(m1, f);
        for (QuakeEntry qe: m2) { 
            System.out.println(qe);
        }
        // filter location and distance.
        Location tokyo = new Location(35.42, 139.43);
        Filter disF = new DistanceFilter(10000000, tokyo);
        ArrayList<QuakeEntry> m3 = filter(list, disF);
        disF = new PhraseFilter("end", "Japan");
        ArrayList<QuakeEntry> m4 = filter(m3, disF);
        for (QuakeEntry qe: m4) { 
            System.out.println(qe);
        }
    }
    
    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");        
        
        // create match all filter
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagFilter(0.0, 2.0));
        maf.addFilter(new DepthFilter(-100000.0, -10000.0));
        maf.addFilter(new PhraseFilter("any", "a"));
        ArrayList<QuakeEntry> m5 = filter(list, maf);
        for (QuakeEntry qe: m5) { 
            System.out.println(qe);
        }
        System.out.println(maf.getName());
    }
    
    public void testMatchAllFilter2(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");        
        
        // create match all filter
        MatchAllFilter maf = new MatchAllFilter();
        Location tulsa = new Location(36.1314, -95.9372);
        
        maf.addFilter(new MagFilter(0.0, 3.0));
        maf.addFilter(new DistanceFilter(10000000, tulsa));
        maf.addFilter(new PhraseFilter("any", "Ca"));
        ArrayList<QuakeEntry> m5 = filter(list, maf);
        for (QuakeEntry qe: m5) { 
            System.out.println(qe);
        }
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
