
/**
 * Generate random text based on Markov model
 * 
 * @author Dong Pei
 * @version Apr. 15. 2017
 */


import java.util.*;
public class MarkovFour extends AbstractMarkovModel{
    
    public MarkovFour() {
        myRandom = new Random();
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
        int index = myRandom.nextInt(myText.length()-4);
        String key = myText.substring(index, index+4);
        sb.append(key);
        for(int k=0; k < numChars-4; k++){
            ArrayList<String> follows = getFollows(key); 
            if (follows.size() == 0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key= key.substring(1,4)+next;
        }
        return sb.toString();
    }   
    
    
    public String toString(){
        return "at 4";
        
    }
}
