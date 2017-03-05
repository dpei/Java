
/**
 * This program import .csv file and find country name or country details
 * with specific requirement.
 * 
 * @author Dong Pei
 * @created Mar. 5. 2017
 * @last modified Mar. 5. 2017
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class countryExport {
    // Return the info of a specific country in the csv file
    // Input: csv file, country name.
    // Output: country info, if no country found in the csv,
    //         return "NOT FOUND".
    public String ctyInfo(CSVParser parser, String country){
        String res = "";
        for (CSVRecord record : parser){
            String currCty = record.get("Country");
            String ept = record.get("Exports");
            String value = record.get("Value (dollars)");
            if (currCty.equals(country)){
                res = currCty+": "+ept+": "+value;
            }
        }
        if (res.equals("")){
            return "NOT FOUND";
        } else {
            return res;
        }
    }
    public String ctyTwoPd(CSVParser parser, String pd1, String pd2){
        String res = "";
        for (CSVRecord record : parser){    
            String currCty = record.get("Country");
            String ept = record.get("Exports");
            if (ept.contains(pd1) && ept.contains(pd2)){
                res = currCty+": "+ept+": ";
            }
        }
        return res;
    }
    
    
    
    public void testCtyTwoPd(){
        FileResource fi = new FileResource();
        CSVParser parser = fi.getCSVParser();
        System.out.println(ctyTwoPd(parser, "tea", "sugar"));  
        
        
    }
    
    public void testCtyInfo(){
        FileResource fi = new FileResource();
        CSVParser parser = fi.getCSVParser();
        System.out.println(ctyInfo(parser, "Germany"));  
    }
    

    
}
