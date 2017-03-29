/**
 * This program stores different codons in a HashMap object and store the frequency of
 * different codons in the Hash map
 * 
 * @author Dong Pei
 * @created Mar. 28. 2017
 * @last modified Mar. 29, 2017
 */


import java.util.*;
public class dnaHash {
    private HashMap<String, Integer> dnaMap;
    public dnaHash(){
        dnaMap = new HashMap<String, Integer>();
    }
    // build a map that has every codon with its frequency. Map based on the start codon.
    private void buildCodonMap(int start, String dna){
        dnaMap.clear();
        // interate through the string
        for (int k=start; k<dna.length()-2; k=k+3){
            String codon = dna.substring(k, k+3);
            if(!dnaMap.containsKey(codon)){
                dnaMap.put(codon,1);
            } else {
                dnaMap.put(codon,dnaMap.get(codon)+1);
            }
        }
    }
    // get the biggest frequency number from the hash map. return the codon that has the most occurence
    private String getCommon(HashMap<String, Integer> dnaMap){
        String maxCodon = null;
        int maxFreq = 0;
        for (String s : dnaMap.keySet()){
            if (dnaMap.get(s) > maxFreq){
                maxFreq = dnaMap.get(s);
                maxCodon = s;
            }
        }
        return maxCodon;
    }
    public void tester(){
        buildCodonMap(2, "CGTTCAAGTTCAA");
        System.out.println("the most frequent codon is: "+ getCommon(dnaMap));
        for (String s : dnaMap.keySet()){
            System.out.println(dnaMap.get(s)+ "\t"+s);
        }
    }
}
