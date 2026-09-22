package com.appapplication.com.Type;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type")
public class TypeController {


    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Type Controller";
    }
}
