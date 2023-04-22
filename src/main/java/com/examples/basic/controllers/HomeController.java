package com.examples.basic.controllers;

import com.examples.basic.services.TesseractService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private static final String defaultURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Computer_modern_sample.svg/1920px-Computer_modern_sample.svg.png";
    
    @Autowired
    private TesseractService tesseractService;    

    @RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
    public String home(HttpServletRequest request, Model model) {
        String urlAddress = request.getParameter("address");
        model.addAttribute("address", urlAddress == null ? defaultURL : urlAddress);
        model.addAttribute("message", tesseractService.process(urlAddress));
        return "index.html";
    }
}
