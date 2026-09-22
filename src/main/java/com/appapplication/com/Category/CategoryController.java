package com.appapplication.com.Category;

import com.appapplication.com.Application.Application;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Category Controller";
    }
}
