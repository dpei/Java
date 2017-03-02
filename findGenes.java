
/**
 * This program find genes within a DNA string.
 * What is DNA: A DNA string is composed by a string of letters (A,T,C,G).
 * What is a gene: A gene is a subset of DNA string
 *                 that start with ATG and end with TAA.
 * In addition, the length of a gene should be a number of multiple 3, such as 6 bp or 12 bp
 * 
 * @author Dong Pei
 * @created Mar. 1. 2016
 * @last modified Mar. 1. 2016
 */


public class findGenes {
    public String findGenes(String DNA){
        String gene = "";
        // find ATG as start codon
        int startIndice = DNA.indexOf("ATG");
        // If there is no start codon, return error message.
        if (startIndice == -1) {
            return "No start codon";
        } else {
         // find TAA as a stop codon, startIndice+3 means only find TAA after startCodon
            int stopIndice = DNA.indexOf("TAA", startIndice + 3);
            if (stopIndice == -1) {
            return "No stop codon found";
            } else {
                gene = DNA.substring(startIndice, stopIndice + 3);
                if (gene.length() % 3 == 0) {
                    return gene;
                } else {
                    return "No gene found because gene length is wrong";
                }
            }
        }
    }   
    public void testFindGenes(){
        String DNA = "AATTGCGTAATATCGGT";
        System.out.println("DNA strand is "+ DNA);
        String gene = findGenes(DNA);
        System.out.println("The gene within is (ATG control) " + gene);
           
        // DNA and gene only need to declare once each time.
        DNA = "AATGCGTAATTAATCG";
        System.out.println("DNA strand is "+ DNA);
        gene = findGenes(DNA);
        System.out.println("The gene within is " + gene);
                
        DNA = "CGATGGTTGAATAAGCCTAAGCTATAA";
        System.out.println("DNA strand is (positive control) "+ DNA);
        gene = findGenes(DNA);
        System.out.println("The gene within is " + gene);
               
        DNA = "CGATGGTTGAATAAGCCTAAGCTAAA";
        System.out.println("DNA strand is (positive control) "+ DNA);
        gene = findGenes(DNA);
        System.out.println("The gene within is " + gene);
        
        DNA = "CGATGGTTGATATAGCCTAGCTACAA";
        System.out.println("DNA strand is "+ DNA);
        gene = findGenes(DNA);
        System.out.println("The gene within is (TAA control) " + gene);
    }
    
}
