package com.example.cmsapplication.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping(value="/hello")
    public String sayHello(){
        return "Hello World";
    }

    @RequestMapping(value="/name")
    public String sayName(){
        return "Rohith Gadu";
    }

}
