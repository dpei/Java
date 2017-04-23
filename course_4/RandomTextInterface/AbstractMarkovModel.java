
/**
 * Abstract class modified
 * 
 * @author Dong Pei
 * @version Apr. 16. 2017
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    // based on the training text file
    // return a array list of strings that is right next to the key.
    protected ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<String>();
        int start = 0;
        while (start < myText.length()){
            int Ind = myText.indexOf(key, start);
            if (Ind == -1 || Ind+key.length() > myText.length()-1){
                break;
            } else {
                String text = myText.substring(Ind+key.length(), Ind+key.length()+1);
                follows.add(text);
                start = Ind + key.length();
            }
        }
        return follows;
    }
 
    
    abstract public String getRandomText(int numChars);
    
    abstract public String toString();
    
}
