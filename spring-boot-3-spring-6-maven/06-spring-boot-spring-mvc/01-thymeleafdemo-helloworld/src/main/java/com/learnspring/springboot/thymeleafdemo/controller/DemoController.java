package com.learnspring.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class DemoController {
    // create a mapping for "/hello"

    @GetMapping("/hello")
    public String sayHello(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());

        // helloworld is the name of the html file
        return "helloworld";
    }
}
