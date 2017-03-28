
/**
 * This class read in a Shakespeare's play txt file and returns the main character name
 * by counting who speakes the most frequently in the play. The output prints out the 
 * most frequent names. Note thsi method is error prone because a regular sentense also
 * return as one result. But it will not be as frequent as a name.
 * 
 * @author: Dong Pei
 * @created: Mar. 28. 2017
 * @last modified: Mar. 28. 2017
 */

import edu.duke.*;
import java.util.*;

public class characterName {
    private ArrayList<String> uniqueNames;
    private ArrayList<Integer> freqs;
    public characterName(){
        uniqueNames = new ArrayList<String>();
        freqs = new ArrayList<Integer>();
    }
    private void findUnique(){
        FileResource fi = new FileResource();
        uniqueNames.clear();
        freqs.clear();
        for (String s : fi.lines()){
            // find name before period
            String[] split = s.split("\\.");
            String name = split[0].trim().toUpperCase();
            int ind = uniqueNames.indexOf(name);
            if (ind == -1){
                uniqueNames.add(name);
                freqs.add(1);
            } else {
                int value = freqs.get(ind);
                freqs.set(ind, value+1);
            }
        }
    }
    private int findMaxInd(){
        int max = freqs.get(0);
        int maxInd = 0;
        for (int k=0; k<freqs.size(); k++){
            if (max < freqs.get(k)){
                max = freqs.get(k);
                maxInd = k;
            }
        }
        return maxInd;
    }
    public void tester(){
        findUnique();
        int maxInd = findMaxInd();
        System.out.println("The max word/freq is "+uniqueNames.get(maxInd)+freqs.get(maxInd));
        for (int k=0; k<freqs.size(); k++){
            System.out.println(freqs.get(k)+"\t"+uniqueNames.get(k));
        }
    }
}
