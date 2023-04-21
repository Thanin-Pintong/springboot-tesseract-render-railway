package com.examples.basic.services;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.leptonica.PIX;
import static org.bytedeco.leptonica.global.lept.pixDestroy;
import static org.bytedeco.leptonica.global.lept.pixRead;
import org.bytedeco.tesseract.TessBaseAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TesseractService {
    
    private static final String TESS_DATA_PATH = "/usr/share/tesseract-ocr/4.00/tessdata";
    private static final String defaultURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Computer_modern_sample.svg/1920px-Computer_modern_sample.svg.png";
    private final Logger log = LoggerFactory.getLogger(TesseractService.class);
    
    public String process(String urlAddress) {
        String ocrResult = null;
        BytePointer outText = null;
        TessBaseAPI api = null;
        PIX image = null;
        try {
            api = new TessBaseAPI();

            // Initialize tesseract-ocr with English, without specifying tessdata path
            if (api.Init(TESS_DATA_PATH, "tha+eng") != 0) {
                throw new Exception("Could not initialize tesseract.");
            }

            // Open input image with leptonica library
            if (urlAddress == null || urlAddress.trim().equals("")) urlAddress = defaultURL;
            URL url = new URL(urlAddress);
            File file = Loader.cacheResource(url);
            
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
