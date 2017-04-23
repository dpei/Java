
/**
 * This program findDefGene can find a defined gene in a region within a DNA string
 * What is DNA: A DNA string is composed by a string of letters (A,T,C,G).
 * What is a gene: A gene is a subset of DNA string
 *                 that start with ATG and end with TAA.
 *                 In this specific program, you can define you start and stop codon
 * @author Dong Pei
 * @created Mar.1.2017
 * @last modified Mar.1.2017
 * 
 */
public class findDefGen {
    public String findDefGenes(String DNA, String staCon, String stpCon){
        String gene = "";
        // find ATG as start codon
        int startIndice = DNA.indexOf(staCon);
        // If there is no start codon, return error message.
        if (startIndice == -1) {
            return "No start codon";
        } else {
         // find TAA as a stop codon, startIndice+3 means only find TAA after startCodon
            int stopIndice = DNA.indexOf(stpCon, startIndice + 3);
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
    public void testFindDefGenes(){
        String DNA = "AAGTGCGTAATATCGGT";
        System.out.println("DNA strand is "+ DNA);
        String gene = findDefGenes(DNA, "ATG", "TAA");
        System.out.println("The gene within is (start codon missing) " + gene);
           
        // DNA and gene only need to declare once each time.
        DNA = "AATGCGTAATTAATCG";
        System.out.println("DNA strand is "+ DNA);
        gene = findDefGenes(DNA, "TTT", "TAA");
        System.out.println("The gene within is (start codon missing) " + gene);
                
        DNA = "CGATGGTTGAATAAGCCTAAGCTATAA";
        System.out.println("DNA strand is  (stop codon missing) "+ DNA);
        gene = findDefGenes(DNA, "ATG", "GGG");
        System.out.println("The gene within is " + gene);
               
        DNA = "CGATGGTTGAATAAGCCTAAGCTAAA";
        System.out.println("DNA strand is (positive control) "+ DNA);
        gene = findDefGenes(DNA, "GGT", "CTA");
        System.out.println("The gene within is (positive control) " + gene);
    }
}
