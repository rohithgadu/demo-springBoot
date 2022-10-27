package com.example.cmsapplication.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping
public class HomePage {

    @RequestMapping
    public String homepage(){
        return ("A simple SpringBoot Application is running at"+" "+new Date());
    }
}
