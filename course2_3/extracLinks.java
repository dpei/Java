
/**
 * This method extract the youtube links from a input webpage.
 * A webpage may contains different links in its HTML.
 * This method only returns youtube.com links in the form of
 * “http:[stuff]youtube.com[stuff]”
 * 
 * 
 * @author Dong Pei
 * @created Mar. 2. 2016
 * @last modified Mar. 2. 2016
 */

import edu.duke.*;
public class extracLinks {
    // This function extract all URL content from the website and returns all 
    public String findYt(String word){
        // change the string to lower case
        String lowS = word.toLowerCase();
        // if youtube.com is in the word
        int tf = lowS.indexOf("youtube.com");
        if (tf == -1){
            return "";            
        } else {
            int start = lowS.indexOf("\"http");
            int end = lowS.indexOf("\"", start+4);
            return word.substring(start, end+1);
        }
    }
    public void testFindYt(){
        String test = "/common/\"http:imyoutube.comages\"/duke.gif";
        System.out.println(test);
        System.out.println("positive control "+findYt(test));
        test = "/common/imyoages/duke.gif";
        System.out.println("negative control "+ findYt(test));
    }
    public void extractURL(){
        // Load webpage successfully
        URLResource res = new URLResource("view-source:http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String line : res.lines()) {
            System.out.println(findYt(line));
        }
    }
}