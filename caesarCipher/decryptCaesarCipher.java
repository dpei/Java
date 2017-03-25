
/**
 * This method is used to decrypt Caesar Cipher. 
 * The method it use depend on the fact that letter "e" is the most common word in English. 
 * By find the most common letter in an encrypted message, we could find the key. And thus
 * we are able to decrypt the message.
 * 
 * @author Dong Pei
 * @created Mar. 9. 2017
 * @last modified Mar. 10. 2017
 */

import edu.duke.*;
import java.io.*;

public class decryptCaesarCipher {
    // takes a string and return a array of integers 
    // that counts the number of letters in the string.
    public int[] countLetter(String enMsg){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] freq = new int[26];
        for (int i = 0; i < enMsg.length(); i++){
            char ch = Character.toUpperCase(enMsg.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1){
                freq[index]  += 1;
            }
        }
         return freq;
    }
    // take an array and return the index number (integer)
    // of the highest value in the array
    public int maxIndex(int[] freq){
        int maxFreq = -1;
        int maxI = 0;
        for (int i = 0; i < freq.length; i++){
            if (freq[i] > maxFreq){
                maxFreq = freq[i];
                maxI = i;
            }
        }
        return maxI;
    }
    public int getKey(String enMsg){
        int[] freq = countLetter(enMsg);
        int Eindex = maxIndex(freq);
        int key = Eindex - 4;
        if (key < 0){
            key = 26  - (4 - Eindex);
        }
        return key;
    }
    public String decryptMsg(String enMsg){
        // Utilize the previous class encodeCarsar in the same project.
        encodeCaesar cc = new encodeCaesar();
        int key = getKey(enMsg);
        // call the function in cc
        return cc.encryptMsg(enMsg, 26-key);
    }
    public String halfString(String enMsg, int start){
        StringBuilder zeroMsg = new StringBuilder();
        zeroMsg.setLength(enMsg.length()/2+1);
        StringBuilder oneMsg = new StringBuilder();
        oneMsg.setLength(enMsg.length()/2);        
        for (int i = 0; i < enMsg.length(); i++){
            if (i%2 == 0){
                zeroMsg.setCharAt(i/2, enMsg.charAt(i));
            } else {
                oneMsg.setCharAt((i-1)/2, enMsg.charAt(i));
            }
        }
        if (start == 0){
            return zeroMsg.toString();
        } else if (start ==1) {
            return oneMsg.toString();
        } else {
            return "start value is wrong";
        } 
    }
    public String decryptTwoKey(String enMsg){
        String zeroEnMsg = halfString(enMsg, 0);
        String oneEnMsg = halfString(enMsg, 1);
        int zeroKey = getKey(zeroEnMsg);
        int oneKey = getKey(oneEnMsg);
        encodeCaesar cc = new encodeCaesar();
        String Msg = cc.twoKeyEncrypt(enMsg, 26-zeroKey, 26-oneKey);
        return Msg;
    }
    
    
    public void testDecryptTwoKey(){
        String enMsg = "omomomomomomom!";
        if (decryptTwoKey(enMsg).equals("eeeeeeeeeeeeee!")){
            System.out.println("passed test case 1");
        } else {
            System.out.println("failed test case 1");
        }
        
        enMsg = "vsvsvsvsvsvsvs";
        if (decryptTwoKey(enMsg).equals("eeeeeeeeeeeeee")){
            System.out.println("passed test case 2");
        } else {
            System.out.println("failed test case 2");
        }
        
        
        enMsg = "vbvbvbvbvbvbvb";
        if (decryptTwoKey(enMsg).equals("eeeeeeeeeeeeee")){
            System.out.println("passed test case 3");
        } else {
            System.out.println("failed test case 3");
        }

        enMsg = "CZOJQ IVDZLE RQKXTH BRPK WIRKB!vbvbvb";
        if (decryptTwoKey(enMsg).equals("FIRST LEGION ATTACK EAST FLANK!eeeeee")){
            System.out.println("passed test case 4");
        } else {
            System.out.println("failed test case 4");
        }
    }
    
    
    //test cases
    public void testCountLetter(){
        String enMsg = "aaaaaabcc";
        int[] freq = countLetter(enMsg);
        for (int i =0; i<freq.length; i++){
            System.out.println(freq[i]);
        }
    }
    public void testDecryptMsg(){
        //System.out.println(decryptMsg("Wzijk Cvxzfevvvv"));
        //First Legioneeeee
        //mmmmmmooooooooooo
        //String enMsg =  "";
        //System.out.println(enMsg);
        //int[] freq = countLetter(enMsg);
        //for (int i =0; i<freq.length; i++){
        //    System.out.println(freq[i]);
        //}
        System.out.println("key for zzz"+ getKey("zzzzz"));
        System.out.println(decryptMsg("mmmmmoooooooooo"));
    }
    public void testHalfString(){
        System.out.println(halfString("Qbkm Zgis", 0));
        System.out.println(halfString("Qbkm Zgis", 1));
    }
}
