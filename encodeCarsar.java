
/**
 * This program encrypt the message with Carsar Cipher principle. The second method 
 * encrypt the message with two keys.
 * 
 * @author Dong Pei
 * @created Mar. 8. 2017
 * @last modified Mar. 8. 2017
 */


import edu.duke.*;
import java.io.*;
public class encodeCarsar {
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
    
    
    public void testEncryptMsg(){
        System.out.println(encryptMsg("FIRST LEGION ATTACK EAST FLANK!", 23));
        System.out.println(encryptMsg("First Legion ATTACK EAST FLANK!", 17));
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
    
    public void testTwoKeyEncrypt(){
        System.out.println(twoKeyEncrypt("First Legion !", 23, 17));
    }
}
