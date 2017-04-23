
/**
 * Use hashmap to rewrite the getRandomText() method so that the method does 
 * not have to rescan keys when they appear multiple times.
 * 
 * @author Dong Pei
 * @created Apr. 15. 2017
 */

import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel{
    private int myNumber;
    private HashMap<String, ArrayList<String>> map;
    public EfficientMarkovModel(int Number) {
        myRandom = new Random();
        myNumber = Number;
        map = new HashMap<String, ArrayList<String>>();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }

    public void buildMap(){
        for (int k=0; k<(myText.length()-myNumber); k++) {
            String key = myText.substring(k, k+myNumber);;
            String follow = myText.substring(k+myNumber, k+myNumber+1);
            if (map.containsKey(key)) {
                // put() method?
                map.get(key).add(follow);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(follow);
                map.put(key, list);
            }
        }
    }
    
    
    
    
//     public void printHashMapInfo(){
//         buildMap();
//         System.out.println("the total key number is: "+map.size());
//         
//         int maxFreq = 0;
//         String maxString = "null";
//         for (String s : map.keySet()){
//             System.out.println(s);
//             System.out.println(map.get(s));            
//         
//         }
//         System.out.println("most frequent key is: "+maxString);
//         System.out.println("most frequent key set size is: " +maxFreq );
//     }
    
    public ArrayList<String> getFollows(String key){
        return map.get(key);
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
            if (follows == null){
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
        return "Hashmap model at degree "+ myNumber;        
    }
}
