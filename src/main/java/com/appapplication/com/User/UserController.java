package com.appapplication.com.User;

import com.appapplication.com.AppApplication;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{applicationId}")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to User Controller";
    }


    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@PathVariable Long applicationId, @RequestBody UserApplication userApplication){
       boolean isSaved= userService.addUser(applicationId,userApplication);
       if(isSaved){
           return new ResponseEntity<>("User Added Successfully", HttpStatus.OK);
       }else {
           return new ResponseEntity<>("User Not Added", HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserApplication>> getAllUser(@PathVariable Long applicationId){

       List<UserApplication> userApplications= userService.getAllUser();
       return new ResponseEntity<>(userApplications, HttpStatus.OK);
    }
}
