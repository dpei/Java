
/**
 * Modified from the duke project, tested all methods in LogAnalyzer.
 * 
 * @author Dong Pei
 * @version Mar. 30. 2017
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        System.out.println("TEST CASE 1");
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
        System.out.println("the unique IP number is: "+ la.countUniqueIPs());
        System.out.println("the unique IPs and freqs are: "+ la.visitPerIP());

        System.out.println("TEST CASE 2");
        LogAnalyzer la2 = new LogAnalyzer();
        la2.readFile("weblog-short_log");
        la2.printAll();
        System.out.println("the unique IP number in Sep 14 is: "+ la2.uniqueIpOnDay("Sep 14"));
        System.out.println("the unique IP number in Sep 30 is: "+ la2.uniqueIpOnDay("Sep 30"));
    }
}
