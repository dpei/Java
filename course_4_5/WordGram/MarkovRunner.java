
/**
 * Generate random text based on Markov model with WordGram class
 * 
 * @author Duke
 * @modified: Dong Pei
 * @version Apr. 18. 2016
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        }
    }

    public void runMarkov(){ 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' ');
        MarkovWord mw = new MarkovWord(3); 
        runModel(mw, st, 200, 643); 
    }

    public void compareMethods (){
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' ');
        System.out.println(System.nanoTime());
        MarkovWord mw = new MarkovWord(2); 
        runModel(mw, st, 100, 42);
        System.out.println(System.nanoTime());
        EfficientMarkovWord emw = new EfficientMarkovWord(2);        
        runModel(emw, st, 100, 42);
        System.out.println(System.nanoTime());
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
