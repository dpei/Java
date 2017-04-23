
/**
 * test methods in MarkovOne class
 * 
 * @author Dong Pei
 * @version Apr. 13. 2017
 */

import java.util.*;
import edu.duke.*;
public class Tester {
    public void smallTester(){
        String a = "this is a test";
        String b = a.substring(29,30);
        System.out.println(b);
    }
    
    public void testGetFollows(){
        MarkovOne one = new MarkovOne();
        one.setTraining("this is a test yes this is a test.");
        ArrayList<String> follows = one.getFollows("t");
        System.out.println(follows);
    }
    public void testGetFollowsWithFile(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne one = new MarkovOne();
        one.setRandom(42);
        one.setTraining(st);
        ArrayList<String> follows = one.getFollows("t");
        System.out.println(follows.size());
    }
    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
}
