
/**
 * Write a description of makeGray here.
 * 
 * @author Dong Pei
 * @version Feb.28.2016
 * @last modified Mar.1.2016
 */
import edu.duke.*;
import java.io.*;
public class convertGray{
    public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            int avg = (inPixel.getGreen()+inPixel.getRed()+inPixel.getBlue())/3;
            pixel.setRed(avg);
            pixel.setBlue(avg);
            pixel.setGreen(avg);
        }
        return outImage;
    }
    /* Test for one simple case */
    
    public void testGray(){
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    /**This command could print the file name
    * System.out.println(f); when you have a void, you have a method to 
    * be called in the object you created. Otherwise no.
    */    
    public void saveGray(){
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource outImage = makeGray(inImage);
            String inName = inImage.getFileName();
            String outName = "gray-" + inName;
            outImage.setFileName(outName);
            outImage.draw();
            outImage.save();
        }
    }
}

