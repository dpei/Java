
/**
 * test cases for MarkovWord class
 * 
 * @author Dong Pei
 * @version Apr. 18. 2017
 */
public class MarkovWordTester {
    public void testIndexOf(){
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        int size = 4;
        int index = 2;
        WordGram wg = new WordGram(words,index,size);
        
        String training = "he getRandomText method has one integer a test this is parameter named";
        String[] myText = training.split("\\s+");
        MarkovWord mw = new MarkovWord(3);
        System.out.println(mw.indexOf(myText, wg, 0));
        
    }
    
    public void testGetFollows(){
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        int size = 1;
        int index = 2;
        WordGram wg = new WordGram(words,index,size);
        
        String training = "he getRandomText a test a this a is method has one integer a test this is parameter named";
        
        MarkovWord mw = new MarkovWord(3);
        mw.setTraining(training);
        System.out.println(mw.getFollows(wg));
        
    }
    
   
}
