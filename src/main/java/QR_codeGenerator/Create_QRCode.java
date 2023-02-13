package QR_codeGenerator;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


public class Create_QRCode {
    public static void main(String[] args){
        try{
            String qrCodeData = "Lydia, would you be my Val";
            String filePath = "C:\\Tools\\lydia.jpg";
            String charset = "ISO-8859-1";
            Map <EncodeHintType, ErrorCorrectionLevel >
                    hintMap = new HashMap <EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
            new String(qrCodeData.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, 200, 200, hintMap);
             MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                    .lastIndexOf('.') * 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
                System.err.println(e);

            }
        }
    }

