/**
 * VigenereBreaker class was written by Dong to decrypt the VigenereBreaker
 * 
 * 
 * @author Dong Pei
 * @created Mar. 31. 2017
 * @last modified: Mar. 31. 2017
 */


import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder result = new StringBuilder();  
        int i = 0;
        for (char c : message.toCharArray()) {
            if (i % totalSlices == whichSlice){
                result.append(c);   
            }
            i++;
        }
        return result.toString();
    }
    // test cases
    private void testVigenereBreaker(){
        System.out.println("adgjm equals: "+sliceString("abcdefghijklm", 0, 3));
        System.out.println("behk equals: "+sliceString("abcdefghijklm", 1, 3));
        System.out.println("ej equals: "+sliceString("abcdefghijklm", 4, 5));
    }
    
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        for (int i=0; i<klength; i++){
            String ithSliceString = sliceString(encrypted, i, klength);
            CaesarCracker ck = new CaesarCracker();
            int ithKey = ck.getKey(ithSliceString);
            key[i] = ithKey;
        }
        return key;
    }
    // test cases
    private void testTryKeyLength(){
        FileResource fi = new FileResource("VigenereTestData/athens_keyflute.txt");
        String enMsg = fi.asString();
        String key = Arrays.toString(tryKeyLength(enMsg, 5, 'e'));
        System.out.println(key);
    }

    public void breakVigenere () {
        FileResource fi = new FileResource("VigenereTestData/athens_keyflute.txt");
        String enMsg = fi.asString();
        System.out.println(enMsg);
        int[] key = tryKeyLength(enMsg, 5, 'e');
        VigenereCipher vc = new VigenereCipher(key);
        System.out.println(vc.decrypt(enMsg));
    }
    
}
