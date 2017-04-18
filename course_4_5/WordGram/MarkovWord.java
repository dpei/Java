
/**
 * Uses WordGram class to handle any number of words.
 * 
 * @author Dong Pei
 * @version Apr. 18. 2017
 */

import java.util.*;
public class MarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    
    public MarkovWord(int order) {
        myOrder = order;
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);
        WordGram kGram = new WordGram(myText, index, myOrder);
        sb.append(kGram.toString());
        for(int k=0; k < numWords-myOrder; k++){
            ArrayList<String> follows = getFollows(kGram);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            kGram = kGram.shiftAdd(next);
        }
        return sb.toString().trim();
    }
    
    // search the index that match target from start position in the String array
    public int indexOf(String[] words, WordGram target, int start){
        for (int i=start; i<=words.length-target.length(); i++){
            WordGram wg = new WordGram(words, i, target.length());
            if (wg.equals(target)){
                return i;
            }            
        }
        return -1;
    }
    
    public ArrayList<String> getFollows(WordGram kGram) {
        //public void getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        int start = 0;
        while (start < myText.length-kGram.length()){
            int Ind = indexOf(myText, kGram, start);
            if (Ind == -1 || Ind == myText.length-kGram.length()){
                // step out of the loop
                break;
            } else {
                String text = myText[Ind+kGram.length()];
                follows.add(text);
                start = Ind+1;
            }
        }
        return follows;
    }
}
