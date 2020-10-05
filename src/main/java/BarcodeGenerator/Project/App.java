package BarcodeGenerator.Project;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap; 
import java.util.Map; 
  
import javax.imageio.ImageIO; 
  
import com.google.zxing.BarcodeFormat; 
import com.google.zxing.BinaryBitmap; 
import com.google.zxing.EncodeHintType; 
import com.google.zxing.MultiFormatReader; 
import com.google.zxing.MultiFormatWriter; 
import com.google.zxing.NotFoundException; 
import com.google.zxing.Result; 
import com.google.zxing.WriterException; 
import com.google.zxing.client.j2se.BufferedImageLuminanceSource; 
import com.google.zxing.client.j2se.MatrixToImageWriter; 
import com.google.zxing.common.BitMatrix; 
import com.google.zxing.common.HybridBinarizer; 
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel; 
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    		 throws WriterException, 
             IOException, 
             NotFoundException
    {
    	String Data="https://nikhilasri.github.io/";
    	String path="D:\\barcode";
        Map<EncodeHintType,ErrorCorrectionLevel> hashMap= new HashMap<EncodeHintType,ErrorCorrectionLevel>(); 
        hashMap.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);
       
		String charset="UTF-8";
		createQR(Data, path,charset, hashMap,200, 200); 
   System.out.println("QR Code Generated!!! "); 

    }
    public static void createQR(String qrCodeData, String path,String charset, Map hashMap,int height, int width) 
            throws WriterException, IOException 
        { 
		BitMatrix matrix= new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),BarcodeFormat.QR_CODE, width, height); 

			File file= new File(path); 
		MatrixToImageWriter.writeToFile(matrix, "png", file);
//    ( 
//            matrix, 
//            path.substring( 
//                path.lastIndexOf('.') + 1), 
//            new File(path)); 

        }
}
       
			
		