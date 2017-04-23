
/**
 * Tester class was written to test the code provide by the Duke team.
 * Also let Dong get familar with the code.
 * 
 * @author Dong Pei
 * @created Mar. 31. 2016
 */


import edu.duke.*;


public class Tester {
    public void testCaesarCipher(){
        FileResource fi = new FileResource();
        String Msg = fi.asString();
        CaesarCipher cc = new CaesarCipher(1);
        String enMsg = cc.encrypt(Msg);
        System.out.println("the encrypted message is: "+ enMsg);
        System.out.println("the decrypted message is: "+ cc.decrypt(enMsg));
    }
    public void testCaesarCracker(){
        FileResource fi = new FileResource("VigenereTestData/titus-small_key5.txt");
        String enMsg = fi.asString();
        CaesarCracker ck = new CaesarCracker();
        System.out.println("the decrypted message is (English): "+ck.decrypt(enMsg));
        // another test case
        FileResource fi2 = new FileResource("VigenereTestData/oslusiadas_key17.txt");
        String enMsg2 = fi2.asString();
        CaesarCracker ck2 = new CaesarCracker('a');
        System.out.println("the decrypted message is (Portuguese): "+ck2.decrypt(enMsg2));
        
    }
    public void testVigenereCipher(){
        FileResource fi = new FileResource("VigenereTestData/titus-small.txt");
        String Msg = fi.asString();
        int[] key = {17,14,12,4};
        VigenereCipher vc = new VigenereCipher(key);
        System.out.println("the encrpyted message is : "+vc.encrypt(Msg));
        
    }
    public void testVigenereBreaker(){
        System.out.println(sliceString);
        
    }
}
