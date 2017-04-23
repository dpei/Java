
/**
 * Added different methods into analyzer
 * 
 * @author Dong Pei
 * @last modified Mar. 30. 2017
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
     
     public HashMap<String, Integer> visitPerIP(){
         HashMap<String, Integer> counts = new HashMap<String, Integer>();
         for (LogEntry record : records){
             String IP = record.getIpAddress();
             if (!counts.containsKey(IP)){
                 counts.put(IP, 1);
             } else {
                 counts.put(IP, counts.get(IP)+1);
             }
         }
         return counts;
     }
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
}
