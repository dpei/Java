
/**
 * The rankName() program takes a input name, input birth year and find the 
 * corresponding name with the same rank in a specific year.
 * 
 * @author Dong Pei
 * @created Mar. 6. 2017
 * @last modified Mar. 8. 2017
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class rankName {
    // Input: a name, the birth year and the gender.
    // Output: the rank of that name in that year.
    // its birth year. return -1 if this name was not found in the file.
    public int getRank(String queryName, int year, String gender){
        FileResource file = new FileResource("data/year/yob"+year+".csv");
        int currRank = 0;
        int rank = 0;
        for (CSVRecord row : file.getCSVParser(false) ){
            String currGend = row.get(1);
            if (currGend.equals(gender)){
                String currName = row.get(0);
                if (currName.equals(queryName)){
                    rank = currRank;
                } else {
                    currRank += 1;
                }
            }
        }
        if (rank == 0) {
            return -1;
        } else {
            return rank + 1;
        }
    }
    // test case
    public void testGetRank(){
        System.out.println("Sarah rank is 12?" + getRank("Sarah", 1882, "F"));
        System.out.println("Joseph rank is 7?"+ getRank("Joseph", 1882, "M"));
    }
    // Input: int: the year of the name list; the rank it refers to, and the gender.
    // Ouput: the corresponding name in that years file.
    public String getName(int year, int rank, String gender){
        
        // FileResource file = new FileResource("data/yob2012short.csv");
        FileResource file = new FileResource("data/year/yob"+year+".csv");
        String Name = "";
        int currRank = 1;
        for (CSVRecord row : file.getCSVParser(false) ){
            String currGend = row.get(1);
            if (currGend.equals(gender)){
                // if currRank equals input rank, return the name
                // if currRank is smaller currR += 1
                String currName = row.get(0);
                if (currRank == rank){
                    Name = currName;
                } 
                currRank += 1;                
            }
        }
        if (Name == "") {
            return "No name found";
        } else {
            return Name;
        }
    }
    // test case for getName()
    public void testGetName(){
        System.out.println("Year 1882 Rank 12 female name is Sarah?" + getName(1882, 12, "F"));
        System.out.println("Year 1882 Rank 7 male name is Joseph?" + getName(1882, 7, "M"));
    }
    // Input: your name, your born year, your gender, a year you want search a new name.
    // Output: the new name that has same popularity in chosen year with your name in 
    //         your born year.
    public String convertName(String yourName, int bornYear, String gender, int newYear){
        int yourRank = getRank(yourName, bornYear, gender);
        String newName = getName(newYear, yourRank, gender);
        return newName;
    }
    // test case for convertName.
    public void testConvertName(){
        System.out.println("Isabella born in 2012 would be Sophia if she was born in 2014."
                            + convertName("Isabella", 2012, "F", 2014));
        System.out.println("Marisol born in 2014 would be Kaya if she was born in 2012."
                            + convertName("Marisol", 2014, "F", 2012));
        System.out.println("Aiden born in 2014 would be James if he was born in 2012."
                            + convertName("Aiden", 2014, "M", 2012));
    }
}
