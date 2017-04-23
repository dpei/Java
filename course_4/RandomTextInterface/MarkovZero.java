
/**
 * Write a description of class MarkovZero here.
 * 
 * @author Duke Software
 * @modified Dong Pei
 * @version Apr. 15. 2017
 */

import java.util.Random;

public class MarkovZero extends AbstractMarkovModel{

	
	public MarkovZero() {
		myRandom = new Random();
	}
	
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	// numChar indicate the total length
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0; k < numChars; k++){
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));
		}
		
		return sb.toString();
	}
	
    public String toString(){
        return "at 0";
        
    }
}
