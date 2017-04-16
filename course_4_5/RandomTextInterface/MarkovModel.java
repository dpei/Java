
/**
 * Generate random text with Markov model with unspecified N value
 * 
 * @author Dong Pei
 * @version Apr. 15. 2017
 */

import java.util.*;
public class MarkovModel extends AbstractMarkovModel{
    private int myNumber;
    
    public MarkovModel(int Number) {
        myRandom = new Random();
        myNumber = Number;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }

    // return a random text with a length of numChar
    public String getRandomText(int numChars){
        if (myText == null) {
            return "";
        }       
        StringBuilder sb = new StringBuilder();
        // generate a random index
        int index = myRandom.nextInt(myText.length()-myNumber);
        String key = myText.substring(index, index+myNumber);
        sb.append(key);
        for(int k=0; k < numChars-myNumber; k++){
            ArrayList<String> follows = getFollows(key); 
            if (follows.size() == 0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key= key.substring(1,myNumber)+next;
        }
        return sb.toString();
    }   
    
    public String toString(){
        return "at "+ myNumber;
        
    }
}
