package com.tmohod.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose '/' end point that will return "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }
}
