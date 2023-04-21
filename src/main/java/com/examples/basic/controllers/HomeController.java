package com.examples.basic.controllers;

import com.examples.basic.services.TesseractService;
import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.leptonica.PIX;
import static org.bytedeco.leptonica.global.lept.pixDestroy;
import static org.bytedeco.leptonica.global.lept.pixRead;
import org.bytedeco.tesseract.TessBaseAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private TesseractService tesseractService;    

    @RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
    public String home(HttpServletRequest request, Model model) {
        String urlAddress = request.getParameter("address");
        model.addAttribute("message", tesseractService.process(urlAddress));
        return "index.html";
    }
}
