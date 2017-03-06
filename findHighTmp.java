
/**
 * This program find the highest temperature within mutltiple .csv files.
 * 
 * @author: Dong Pei
 * @created: Mar. 5. 2017
 * @last modified Mar.6. 2017
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class findHighTmp {
    // Given a list of float numbers, bubbleSort() returns the biggest number in the list
    public CSVRecord findOne(CSVParser parser){
        // initiate null value to curr
        CSVRecord highest = null;
        // assign first one into the curr
        for (CSVRecord row : parser){
            highest = decideHigh(highest, row);
        }
        return highest;
    }
    // Given a .csv file, findHigh() finds the highest temperature within a specific column
    public void testFindOne(){
        FileResource fi = new FileResource();
        CSVRecord highestTmp= findOne(fi.getCSVParser());
        System.out.println(highestTmp.get("TemperatureF"));
    }
    // Given two CSV row files, decide which row is higher in stemperatureF.
    public CSVRecord decideHigh(CSVRecord highest, CSVRecord row){
        if (highest == null) {
                highest = row;
            } else {
                // This convert the string into number
                double rowTmp = Double.parseDouble(row.get("TemperatureF"));
                double highestTmp = Double.parseDouble(highest.get("TemperatureF"));
                if (rowTmp > highestTmp){
                    highest = row;
                }
            }
        return highest;
    }
    // findMlti() scans multiple files and find the highest temperature     
    public CSVRecord findMlti(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord highest = null;
        for (File fi : dr.selectedFiles()){
            FileResource file = new FileResource(fi);
            // for the convinience, row here indicate the highest temp in a file. 
            // not in a row
            CSVRecord row = findOne(file.getCSVParser());
            highest = decideHigh(highest, row);
        }    
        return highest;
    }
    public void testFindMulti(){
        CSVRecord highest = findMlti();
        System.out.println("highest temp is: "+ highest.get("TemperatureF"));
        
    }

}
