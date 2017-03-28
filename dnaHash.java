/**
 * This program stores different codons in a HashMap object and store the frequency of
 * different codons in the Hash map
 * 
 * @author Dong Pei
 * @created Mar. 28. 2017
 * @last modified Mar. 28, 2017
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
        for (int k=0; k<dna.length(); k++){
            String codon = dna.substring(k, k+3);
            if(!dnaMap.containsKey(codon)){
                dnaMap.put(codon,1);
            } else {
                dnaMap.put(codon,dnaMap.get(codon)+1);
            }
        }
    }

    //private getCommon(){
        // get the biggest frequency number from the hash map.
        
        
    //}
    public void tester(){
        buildCodonMap(0, "ATGGGC")
        for (String s : dnaMap.keySet()){
            System.out.println(dnaMap);
    }
    //     private void printCounts(){
    //         
    //     }
}
