package com.example.demo.controller;

import com.example.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyController {

    @Autowired
    MyService myService;

    @GetMapping("/code/number/{number}")
    public String isValid(@PathVariable String number){
        System.out.println("in contrller: "+number);
        if (myService.isValid(number)){
            return "Valid";
        }
        return "Invalid";
    }

}
