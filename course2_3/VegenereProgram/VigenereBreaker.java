/**
 * VigenereBreaker class was created by Dong to decrypt the VigenereBreaker.
 * The program assumes the VC encoding word is 2 or more in length
 * 
 * 
 * @author Dong Pei
 * @created Mar. 31. 2017
 * @last modified: Apr. 2. 2017
 */


import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    
    private HashMap<String, HashSet<String>> languages;
    // initiate all languages in the dictionary folder and store them into one hashmap
    public VigenereBreaker(){
        languages = new HashMap<String, HashSet<String>>();
        String[] languageString = {"English", "Danish", "Dutch", "French", "German", "Italian", 
            "Portuguese"};
        for (String language : languageString){
            String directory = "dictionaries/"+language;
            HashSet<String> dic = readDictionary(new FileResource(directory));
            languages.put(language, dic);
        }
    }
    // slice a string of message into several pieces (totalSlices), and return one specific slice.
    private String sliceString(String message, int whichSlice, int totalSlices) {
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
    // Given 1. an encrypted message; 
    //       2. the length of the key array, 
    //       3. the most common character in that language;
    // Calculate the key array.
    private int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        for (int i=0; i<klength; i++){
            String ithSliceString = sliceString(encrypted, i, klength);
            CaesarCracker ck = new CaesarCracker();
            int ithKey = ck.getKey(ithSliceString);
            key[i] = ithKey;
        }
        return key;
    }
    // read in a dictionary and return Hashset dic for later use
    private HashSet<String> readDictionary(FileResource fi){
        HashSet<String> dic = new HashSet<String>();
        for (String line : fi.lines()){
            String word = line.toLowerCase();
            dic.add(line);
        }
        return dic;
    }
    // count the letters in a specific dictionary and return the most frequent 
    // character in that dictionary.
    private char freqChar(HashSet<String> dic){
        HashMap<Character, Integer> dicCh = new HashMap<Character, Integer>();
        for (String s : dic){
            for (char ch : s.toLowerCase().toCharArray()){
                if (dicCh.containsKey(ch)){
                    dicCh.put(ch, dicCh.get(ch)+1);
                } else {
                    dicCh.put(ch, 1);
                }
            }
        }
        // count the max in HashMap
        char maxInd = 'm';
        int maxFreq = 0;
        for (char c: dicCh.keySet()){
            if (dicCh.get(c)>maxFreq){
                maxFreq = dicCh.get(c);
                maxInd = c;
            }
        }
        return maxInd;
    }
    // Given a string of words, (decrypted string). and a dictionary
    // Count how many words are real words based on that dictionary.
    private int countWords(String message, HashSet<String> dic){
        int valid = 0;
        String[] msg = message.split("\\W");
        for (String word : msg){
            if (dic.contains(word)){
                valid ++;
            }
        }
        return valid;
    }
    // Break the language by trying different key length.
    public String breakForLanguage(String enMsg, HashSet<String> dic){
        int maxValid = 0;
        String Msg = null;
        char commonLetter = freqChar(dic);
        for (int i=2; i<101; i++) {
            int[] key = tryKeyLength(enMsg, i, commonLetter);
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
    // break one specific case by providing the file name.

    // breakAllLan trys different languages and return the most appropriate 
    // language (with most meaningful words.)
    // This method returns the decrypted language as well as the decrypted message
    public String breakAllLan(String enMsg){
        int maxValid = 0;
        String Msg = null;
        for (String language : languages.keySet()){
            HashSet<String> dic = languages.get(language);
            String tempMsg = breakForLanguage(enMsg, dic);
            int valid = countWords(tempMsg, dic);
            if (valid > maxValid){
                maxValid = valid;
                Msg = tempMsg;
            }
        }
        return Msg;
    }
    
    // call breakAllLan
    // passed tests
    public void breakVigenere () {
        FileResource fi = new FileResource("VigenereTestData/german_example.txt");
        String enMsg = fi.asString();
        System.out.println("The encrypted message is: "+enMsg);
        VigenereBreaker vb =  new VigenereBreaker();
        System.out.println("Based on calculation, the decrypted message is: "
                            +breakAllLan(enMsg));
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
    private void testSliceString(){
        System.out.println("adgjm equals: "+sliceString("abcdefghijklm", 0, 3));
        System.out.println("behk equals: "+sliceString("abcdefghijklm", 1, 3));
        System.out.println("ej equals: "+sliceString("abcdefghijklm", 4, 5));
    }
    private void testCountWords(){
        HashSet<String> dic = readDictionary(new FileResource("dictionaries/English"));
        System.out.println(countWords("I am a girl", dic));
    }
    private void testFreqChar(){
        HashSet<String> dic = readDictionary(new FileResource("dictionaries/English"));
        System.out.println(freqChar(dic));
    }
}
