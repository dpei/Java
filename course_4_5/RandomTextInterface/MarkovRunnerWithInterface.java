
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @modified by Dong Pei
 * @version 1.0
 */

import edu.duke.*; 
import java.util.*;
public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setRandom(seed);
        markov.setTraining(text);
        System.out.println("running with Markov model order: " + markov.toString());
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed = 42;
        
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size, seed);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size, seed);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, seed);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size, seed);

    }

    public void testHashMap(){
        EfficientMarkovModel m2 = new EfficientMarkovModel(2);
        m2.setTraining("yes-this-is-a-thin-pretty-pink-thistle");
        m2.setRandom(42);
        //m2.printHashMapInfo();

        
        //printOut(m2.getRandomText(50));
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
    
    public void compareMethods(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 1000;
        int seed = 42;
        
        MarkovModel m2 = new MarkovModel(2);
        System.out.println(System.currentTimeMillis());
        runModel(m2, st, size, seed);
        System.out.println(System.currentTimeMillis());
        
        EfficientMarkovModel em2 = new EfficientMarkovModel(2);
        runModel(m2, st, size, seed);
        System.out.println(System.currentTimeMillis());        
    }
    
}
