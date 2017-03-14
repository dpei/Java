
/**
 * The CaesarCipherBox class is able to generate class Caesar Cipher object based 
 * on a key value
 * 
 * 
 * @author Dong Pei
 * @created Mar. 11. 2017
 * @last modified Mar. 13. 2017
 */
import java.io.*;
import edu.duke.*;
public class CaesarCipherBox {
    private String alphabet;
    private String encryptAlphabet;
    private int mainKey;
    // This is a constructor, have the same name with class
    public CaesarCipherBox(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        encryptAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
    }
    // a method that is a verb
    public String encryptMsg(String Msg){
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

    public String decryptMsg(String enMsg){
        CaesarCipherBox cc = new CaesarCipherBox(26 - mainKey);
        return cc.encryptMsg(enMsg);
    }
}


