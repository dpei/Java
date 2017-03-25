
/**
 * The CaesarCipherTwo class could encrypt a message with two keys provided
 * 
 * @author: Dong Pei
 * @created: Mar. 14. 2017
 * @last modified: Mar. 25. 2017
 */


import java.io.*;
import edu.duke.*;
public class CaesarCipherTwo {
    private String alphabet;
    private String encryptAlphabet1;
    private String encryptAlphabet2;
    private int mainKey1;
    private int mainKey2;
    private String encryptMsg(String Msg, int key, String encryptAlphabet){
        // based on key, generate string
        // StringBuilder was used here for better performance than concatenate two 
        // strings directly.
        StringBuilder encryptMsg = new StringBuilder(Msg);
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
    // This is the constructor
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        mainKey1 = key1;
        mainKey2 = key2;
        encryptAlphabet1 = alphabet.substring(mainKey1) + alphabet.substring(0,mainKey1);
        encryptAlphabet2 = alphabet.substring(mainKey2) + alphabet.substring(0,mainKey2);
    }
    public String encryptTwo(String Msg){
        StringBuilder twoKeyMsg = new StringBuilder(Msg);
        String Key1Msg = encryptMsg(Msg, mainKey1, encryptAlphabet1);
        String Key2Msg = encryptMsg(Msg, mainKey2, encryptAlphabet2);
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
    public String decryptMsg(String enMsg){
        CaesarCipherTwo cc2 = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        return cc2.encryptTwo(enMsg);
    }
}