
/**
 * This method is used to decrypt Caesar Cipher. 
 * The method it use depend on the fact that letter "e" is the most common word in English. 
 * By find the most common letter in an encrypted message, we could find the key. And thus
 * we are able to decrypt the message.
 * 
 * @author Dong Pei
 * @created Mar. 9. 2017
 * @last modified Mar. 9. 2017
 */

import edu.duke.*;
import java.io.*;

public class decryptCaesarCipher {
    public String encryptMsg(String Msg, int key){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // based on key, generate string
        // StringBuilder was used here for better performance than concatenate two 
        // strings directly.
        StringBuilder encryptMsg = new StringBuilder(Msg);
        String encryptAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        for (int i = 0; i < Msg.length(); i++){
            char tmpChar = Msg.charAt(i);
            char MsgChar = Character.toUpperCase(tmpChar);
            int indice = alphabet.indexOf(MsgChar);
            if (indice != -1){
                char enMsgChar = encryptAlphabet.charAt(indice);
                // check uplo and return right letter.
                if (Character.isUpperCase(tmpChar)){
                    encryptMsg.setCharAt(i, enMsgChar);
                } else {
                    encryptMsg.setCharAt(i, Character.toLowerCase(enMsgChar));
                }
            }
        }
        return encryptMsg.toString();
    }
        public String twoKeyEncrypt(String Msg, int key1, int key2){
        StringBuilder twoKeyMsg = new StringBuilder(Msg);
        String Key1Msg = encryptMsg(Msg, key1);
        String Key2Msg = encryptMsg(Msg, key2);
        // combine two strings
        for (int i = 0; i < Msg.length(); i++){
            if (i%2 == 0){
                twoKeyMsg.setCharAt(i, Key1Msg.charAt(i));
            } else {
                twoKeyMsg.setCharAt(i, Key2Msg.charAt(i));                
            }
        }
        return twoKeyMsg.toString();
    }
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
    public void testCountLetter(){
        String enMsg = "aaaaaabcc";
        int[] freq = countLetter(enMsg);
        for (int i =0; i<freq.length; i++){
            System.out.println(freq[i]);
        }
    }
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
    public String decryptMsg(String enMsg){
        int[] freq = countLetter(enMsg);
        int Eindex = maxIndex(freq);
        int key = Eindex - 4;
        if (key < 0){
            key = 26  - (4 - key);
        }
        return encryptMsg(enMsg, 26-key);
    }
    public void testDecryptMsg(){
        System.out.println(decryptMsg("Wzijk Cvxzfevvvv"));
//         First Legioneeeee
//         mmmmmmooooooooooo
//         String enMsg =  "";
//         System.out.println(enMsg);
//         int[] freq = countLetter(enMsg);
//         for (int i =0; i<freq.length; i++){
//             System.out.println(freq[i]);
//         }
//         System.out.println("the maxID is 21"+maxIndex(freq));
        System.out.println(decryptMsg("mmmmmoooooooooo"));
    }
}
