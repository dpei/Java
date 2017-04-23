
/**
 * Test EfficientMarkovWord
 * 
 * @author Dong Pei
 * @version Apr. 18. 2016
 */
public class EfficientMarkovModelTester {
    public void testEfficient(){        
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        int size = 1;
        int index = 2;
        WordGram wg = new WordGram(words,index,size);
        
        String training = "he get Random Text a test a this a is method has one integer a test this is parameter named";
        
        EfficientMarkovWord mw = new EfficientMarkovWord(2);
        mw.setTraining(training);
        mw.printMap();
    }
}
