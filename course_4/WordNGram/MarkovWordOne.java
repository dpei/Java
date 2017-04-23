
/**
 * Modified the indexOf() and created getFollows() method in order to 
 * return single words instead of leters
 * 
 * @author Dong Pei
 * @version Apr. 16. 2017
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordOne() {
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
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key = myText[index];
        sb.append(key);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }
        
        return sb.toString().trim();
    }
    
    // search the index that match target from start position in the String array
    private int indexOf(String[] words, String target, int start){
        for (int i=start; i<words.length; i++){
            if (words[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
    
    public ArrayList<String> getFollows(String key) {
        //public void getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        int start = 0;
        while (start < myText.length){
            int Ind = indexOf(myText, key, start);
            if (Ind == -1 || Ind == myText.length-1){
                break;
            } else {
                String text = myText[Ind+1];
                follows.add(text);
                start = Ind+1;
            }
        }
        return follows;
    }
    
    //tester
    private void testIndexOf(){
        String[] words = new String[]{"apple", "peach", "orange"};
        System.out.println(indexOf(words, "apple", 2));
        
    }
}
