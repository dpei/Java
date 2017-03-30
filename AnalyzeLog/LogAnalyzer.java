
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
     
     public void readFile(String filename) {
         FileResource fi = new FileResource(filename);
         for (String s : fi.lines()){
             LogEntry slog = WebLogParser.parseEntry(s);
             records.add(slog);
         }
     }
        
     public int countUniqueIPs(){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry record : records){
             String IP = record.getIpAddress();
             if (!uniqueIPs.contains(IP)){
                 uniqueIPs.add(IP);
             }
         }
         return uniqueIPs.size();
     }
     
     public int uniqueIpOnDay(String someday){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry record : records){
             String date = record.getAccessTime().toString();
             String IP = record.getIpAddress();
             if (date.indexOf(someday)!=-1 && uniqueIPs.indexOf(IP)==-1){
                 uniqueIPs.add(IP);
             }
         }
         return uniqueIPs.size();
     }
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
}
