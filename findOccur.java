
/**
 * The findOccur(lon, str, freq) program find the occurance of a 
 * short string (str) within a long string (lon). It also detects if
 * short string occured certain times (freq) or more within the
 * longer string.
 * 
 * @author Dong Pei
 * @created Mar. 2. 2017
 * @last modified Mar. 2. 2017
 */

import org.apache.commons.lang3.StringUtils;

public class findOccur {
    public String findOccur(String lon, String str, int freq){
        int theFreq = StringUtils.countMatches(lon, str);
        if (theFreq >= freq) { 
            return "TRUE";
        } else {
            return "FALSE";
        }
    }    
    public void testFindDefGenes(){
        String lon = "helloslkhellodjladfjhello";
        String str = "hello";
        System.out.println(StringUtils.countMatches(lon, str)>=2);
        System.out.println("3 times is "+ findOccur(lon, str, 2));

        lon = "AGGCATGATTG";
        str = "ATG";
        System.out.println("1 time is "+findOccur(lon, str, 2));
    }
}