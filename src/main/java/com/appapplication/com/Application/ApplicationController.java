package com.appapplication.com.Application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class ApplicationController {



    private  ApplicationSevice applicationSevice;


    public ApplicationController(ApplicationSevice applicationSevice) {
        this.applicationSevice = applicationSevice;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Application Controller";
    }



    @PostMapping("/addApplication")
    public ResponseEntity<Application> addApplication(@RequestBody Application application){

        Application application1=  applicationSevice.addApplication(application);
        return new ResponseEntity<>(application1, HttpStatus.OK);
    }
}
