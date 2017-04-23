
/**
 * This program summarize the frequency of word length in one .txt file.
 * the frequency of word length will be stored into an array of int. For
 * word of length 30 or more, the frequency will be grounped into one 
 * frequency.
 * 
 * @author: Dong Pei
 * @created: Mar. 9. 2017
 * @last modified: Mar. 9. 2017
 */

import edu.duke.*;
import java.io.*;
public class topLenght {
    // Input: the file needed to be counted, the max length number
    // Output: an array of integer that has the counts of word length
    //          in the file.
    public int[] countLength(int counts){
         FileResource fi = new FileResource();
         int[] freq = new int[counts];
         for (String s : fi.words()){
             int length = s.length();
             // TODO: length has longer
             freq[length]  += 1;
         }
         return freq;
    }
    // test case
    public void testCountLength(){
        int[] freq = countLength(31);
        for (int i = 0; i < freq.length; i++){
            System.out.println("word length "+i+" frequency is "+freq[i]);
        }
    }
    // return the index that has maxium frequency
    public int maxIndex(int[] freq){
        int max = -1;
        for (int i = 0; i < freq.length; i++){
            if (freq[i] > max){
                max = freq[i];
                i += 1;
            }
        }
        return max;
    }
    // test case
    public void testMaxIndex(){
        int[] freq = countLength(12);
        System.out.println(maxIndex(freq));
    }
}
