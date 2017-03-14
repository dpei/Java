
/**
 * The test class for CaesarCipherBox
 * 
 * @author Dong Pei
 * @created Mar. 13. 2017
 * @last modified Mar. 13. 2017
 */

import java.io.*;
import edu.duke.*;
public class testCaesarCipherBox {
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
    public String decryptMsg(String enMsg){
        int key = getKey(enMsg);
        CaesarCipherBox cc = new CaesarCipherBox(26-key);
        // call the function in cc
        return cc.encryptMsg(enMsg);
    }
    public void testCaesarCipher(){
        FileResource fi = new FileResource();
        String Msg = fi.asString();
        CaesarCipherBox cc = new CaesarCipherBox(18);
        String enMsg = cc.encryptMsg(Msg);
        System.out.println("the encrypted message is:\n"+ enMsg);
        // decrypt is not correct
        String easyDecryptMsg = cc.decryptMsg(enMsg);
        System.out.println("the easy decrypted message with key is:\n "+ easyDecryptMsg);
        String selfDecryptMsg = decryptMsg(enMsg);
        System.out.println("the self decrypted message is:\n "+ selfDecryptMsg);
    }
}
