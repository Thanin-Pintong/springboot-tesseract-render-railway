package com.examples.basic.services;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.leptonica.PIX;
import static org.bytedeco.leptonica.global.leptonica.pixDestroy;
import static org.bytedeco.leptonica.global.leptonica.pixRead;
import org.bytedeco.tesseract.TessBaseAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TesseractService {
    
    private static final String TESS_DATA_PATH = "/usr/share/tesseract-ocr/4.00/tessdata";
    //private static final String TESS_DATA_PATH = "C:\\msys64\\mingw64\\share\\tessdata";
    private final Logger log = LoggerFactory.getLogger(TesseractService.class);
    
    public String process(String urlAddress) {
        String ocrResult = null;
        BytePointer outText = null;
        TessBaseAPI api = null;
        PIX image = null;
        try {
            // Open input image with leptonica library
            URI uri = new URI(urlAddress);
            URL url = new URL(uri.toASCIIString());
            File file = Loader.cacheResource(url);
            
            api = new TessBaseAPI();
            // Initialize tesseract-ocr with Thai+English, with specifying tessdata path
            if (api.Init(TESS_DATA_PATH, "tha+eng") != 0) {
                throw new Exception("Could not initialize tesseract.");
            }
            
            // Use Tesseract API to pass in the value of the input image's resolution
            api.SetVariable("user_defined_dpi", "120");
            
            // Open input image with leptonica library
            image = pixRead(file.getAbsolutePath());
            api.SetImage(image);

            // Get OCR result
            outText = api.GetUTF8Text();
            ocrResult = outText.getString(StandardCharsets.UTF_8);

        } catch (Exception e) {
            log.warn(e.getMessage());
        } finally {
            if (api != null) {
                api.End();
            }
            if (outText != null) {
                outText.deallocate();
            }
            if (image != null) {
                pixDestroy(image);
            }
        }
        return ocrResult != null ? ocrResult : "";
    }    
    
}
