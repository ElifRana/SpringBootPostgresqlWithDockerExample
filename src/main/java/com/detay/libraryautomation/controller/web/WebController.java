package com.detay.libraryautomation.controller.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
public class WebController implements WebMvcConfigurer {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/swagger-ui.html";
    }
}
