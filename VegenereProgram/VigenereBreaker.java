/**
 * VigenereBreaker class was created by Dong to decrypt the VigenereBreaker.
 * The program assumes the VC encoding word is 2 or more in length
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
    public HashSet<String> readDictionary(FileResource fi){
        HashSet<String> dic = new HashSet<String>();
        for (String line : fi.lines()){
            String word = line.toLowerCase();
            dic.add(line);
        }
        return dic;
    }
    public int countWords(String message, HashSet<String> dic){
        int valid = 0;
        String[] msg = message.split("\\W+");
        for (String word : msg){
            if (dic.contains(word)){
                valid ++;
            }
        }
        return valid;
    }
    public String breakForLanguage(String enMsg){
        HashSet<String> dic = readDictionary(new FileResource("dictionaries/English"));
        int maxValid = 0;
        String Msg = null;
        for (int i=2; i<101; i++) {
            int[] key = tryKeyLength(enMsg, i, 'e');
            VigenereCipher vc = new VigenereCipher(key);
            String tempMsg = vc.decrypt(enMsg);
            int valid = countWords(tempMsg, dic);
            if (valid > maxValid){
                maxValid = valid;
                Msg = tempMsg;
            }
        }
        return Msg;
    }
    public void breakVigenere () {
        FileResource fi = new FileResource("VigenereTestData/athens_keyflute.txt");
        String enMsg = fi.asString();
        System.out.println("The encrypted message is: "+enMsg);
        System.out.println("Based on calculation, the decrypted message is: "
                            +breakForLanguage(enMsg));
    }
    
    
    
    
    // all private test methods
    private void testReadDic(){
        HashSet<String> dic = readDictionary(new FileResource("dictionaries/English"));
        System.out.println(dic.contains("are"));
    }
    private void testTryKeyLength(){
        FileResource fi = new FileResource("VigenereTestData/athens_keyflute.txt");
        String enMsg = fi.asString();
        String key = Arrays.toString(tryKeyLength(enMsg, 5, 'e'));
        System.out.println(key);
    }
    // test cases
    private void testVigenereBreaker(){
        System.out.println("adgjm equals: "+sliceString("abcdefghijklm", 0, 3));
        System.out.println("behk equals: "+sliceString("abcdefghijklm", 1, 3));
        System.out.println("ej equals: "+sliceString("abcdefghijklm", 4, 5));
    }
    public void testCountWords(){
        HashSet<String> dic = readDictionary(new FileResource("dictionaries/English"));
        System.out.println(countWords("I am a girl", dic));
    }
}
