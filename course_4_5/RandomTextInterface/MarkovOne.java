
/**
 * Generate random text based on one letter
 * 
 * @author Dong Pei
 * @version Apr. 15. 2017
 */


import java.util.*;;

public class MarkovOne extends AbstractMarkovModel{
    
    
    public MarkovOne() {
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
        int index = myRandom.nextInt(myText.length()-1);
        String key = myText.substring(index, index+1);
        sb.append(key);
        for(int k=0; k < numChars-1; k++){
            ArrayList<String> follows = getFollows(key); 
            if (follows.size() == 0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key= next;
        }
        return sb.toString();
    }
    
    public String toString(){
        return "at 1";
        
    }
}
