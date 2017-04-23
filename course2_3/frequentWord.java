
/**
 * The frequentWord count the most frequent word in a file 
 * You should make all words lowercase before counting them. 
 * Thus, “This” and “this” will both be counted as the lowercase version 
 * of “this”. You should not consider punctuation, so “end” and “end,”
 * 
 * @author Dong Pei
 * @created Mar. 27. 2017
 * @last modified Mar. 27. 2017
 */

import edu.duke.*;
import java.util.*;
public class frequentWord {
    // Two ArrayList corresponds to each other
    private ArrayList<String> uniqueWords;
    private ArrayList<Integer> freqs;
    public frequentWord(){
        uniqueWords = new ArrayList<String>();
        freqs = new ArrayList<Integer>();
    }
    // Find unique values and store the word itself and corresponding frequence into the two arraylist
    private void findUnique(){
        FileResource fi = new FileResource();
        for (String s : fi.words()){
            s = s.toLowerCase();
            int ind = uniqueWords.indexOf(s);
            if (ind == -1){
                // add the word
                uniqueWords.add(s);
                freqs.add(1);
            } else {
                // ArrayList uses .get()
                int value = freqs.get(ind);
                // ArrayList uses .set()
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
        System.out.println("# of unique words are "+freqs.size());
        int maxInd = findMaxInd();
        System.out.println("The max word/freq is "+uniqueWords.get(maxInd)+freqs.get(maxInd));
        for (int k=0; k<freqs.size(); k++){
            System.out.println(freqs.get(k)+"\t"+uniqueWords.get(k));
        }
    }
}
