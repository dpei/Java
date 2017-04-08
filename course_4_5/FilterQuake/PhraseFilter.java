
/**
 * Phrase filter written to filter certain phrase
 * 
 * @author Dong Pei
 * @version Apr. 8. 2016
 */
public class PhraseFilter implements Filter{
    private String location;
    private String word;
    public PhraseFilter (String loc, String wod) { 
        location = loc;
        word = wod;
    }
    public boolean satisfy(QuakeEntry qe) { 
        return((qe.getInfo().startsWith(word) && location.equals("start")) ||
               (qe.getInfo().endsWith(word) && location.equals("end"))||
               (qe.getInfo().contains(word) && location.equals("any")));
    }
    public String getName(){
        return "PhraseFilter";
    }
}
