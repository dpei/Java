
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
    public void testCaesarCipherBox(){
        FileResource fi = new FileResource();
        String Msg = fi.asString();
        CaesarCipherBox cc = new CaesarCipherBox(23);
        String enMsg = cc.encryptMsg(Msg);
        System.out.println("the encrypted message is (23, Cfopq)"+ enMsg);
        // decrypt is not correct
        CaesarCipherBox cc2 = new CaesarCipherBox(3);
        String decryptMsg = cc.encryptMsg("Cfopq");
        System.out.println("the decrypted message is "+ decryptMsg);
    }
}
