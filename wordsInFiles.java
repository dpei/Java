
/**
 * This program counts the word frequency in different files.
 * 
 * @author Dong Pei
 * @created Mar. 29. 2017
 * @last modified Mar. 29. 2017
 */

import java.io.*;
import java.util.*;
import edu.duke.*;

public class wordsInFiles {
    private HashMap<String, ArrayList<String>> wordMap;
    public void wordsInFile(){
        wordMap = new HashMap<String, ArrayList<String>>();
    }
    private void addWords(File f){
        FileResource fi = new FileResource(f);
        String fname = f.getName();
        for (String s : fi.words()){
            if (!wordMap.containsKey(s)){
                ArrayList<String> name = new ArrayList<String>();
                name.add(fname);
                wordMap.put(s,name);
            } else {
                ArrayList<String> name = wordMap.get(s);
                if (!name.contains(fname)){
                    name.add(fname);
                    wordMap.put(s,name);
                }
            }
        }
    }
    private void buildWordMap(){
        wordMap.clear();
        DirectoryResource di = new DirectoryResource();
        for (File f : di.selectedFiles()){
            addWords(f);
        }
        
    }
    public void tester(){
        buildWordMap();
        for (String s: wordMap.keySet()){
            System.out.println(wordMap.get(s)+"\t"+s);
        }
    }
}
