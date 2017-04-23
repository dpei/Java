
/**
 * Added tester() runMarkov() and runMarkovTwo() methods used to call Markov random text generator.
 * 
 * @author Duke
 * @modified Dong Pei
 * @version Apr. 16. 2016
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

    public void runMarkov() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWordOne markovWord = new MarkovWordOne(); 
        runModel(markovWord, st, 120, 175); 
    }
    
    public void runMarkovTwo() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWordTwo markovWord = new MarkovWordTwo(); 
        runModel(markovWord, st, 120, 549); 
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

    // tester
    private void testGetFollows2() { 
        String st = "apple bee apple start apple bee yu";
        MarkovWordTwo markovWord = new MarkovWordTwo(); 
        markovWord.setTraining(st);
        System.out.println(markovWord.getFollows("apple", "bee"));
        System.out.println(markovWord.getFollows("bee", "apple"));
    }
    
    // tester
    private void testGetFollows() { 
        
        String st = "apple bee apple start apple";
        MarkovWordOne markovWord = new MarkovWordOne(); 
        markovWord.setTraining(st);
        System.out.println(markovWord.getFollows("apple"));
        System.out.println(markovWord.getFollows("bee"));
    }
}
