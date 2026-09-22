package com.appapplication.com.Access;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access")
public class AccessController {


    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Access Controller";
    }
}
