
/**
 * This class was used to test the two key object oriented Caesar Cipher 
 * 
 * @author Dong Pei
 * @created: Mar 25 2017
 */


import edu.duke.*;
import java.io.*;


public class testCaesarCipherTwo {
    private int[] countLetter(String enMsg){
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
    private int maxIndex(int[] freq){
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
    private int getKey(String enMsg){
        int[] freq = countLetter(enMsg);
        int Eindex = maxIndex(freq);
        int key = Eindex - 4;
        if (key < 0){
            key = 26  - (4 - Eindex);
        }
        return key;
    }
    private String halfString(String enMsg, int start){
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
    private String decryptTwoKey(String enMsg){
        String zeroEnMsg = halfString(enMsg, 0);
        String oneEnMsg = halfString(enMsg, 1);
        int zeroKey = getKey(zeroEnMsg);
        int oneKey = getKey(oneEnMsg);
        CaesarCipherTwo cc2 = new CaesarCipherTwo(26-zeroKey, 26-oneKey);
        String Msg = cc2.encryptTwo(enMsg);
        return Msg;
    }
    public void simpleTestCaesarCipherTwo(){
        // encrypt message with two keys: 17 and 3
        FileResource fi = new FileResource();
        String Msg = fi.asString();
        CaesarCipherTwo cc2 = new CaesarCipherTwo(17, 3);
        String enMsg = cc2.encryptTwo(Msg);
        System.out.println("the encrypted message is:\n"+ enMsg);
        // decrypt message with the two keys in encryption
        String easyDecryptMsg = cc2.decryptMsg(enMsg);
        System.out.println("the easy decrypted message with key is:\n "+ easyDecryptMsg);
        // decrypt message with two keys unknown. determine keys by most frequent letter (the rea
        // most frequent letter is )
        String selfDecryptMsg = decryptTwoKey(enMsg);
        System.out.println("the self decrypted message is:\n "+ selfDecryptMsg);
    }
}
