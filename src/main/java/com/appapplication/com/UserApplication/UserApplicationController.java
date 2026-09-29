package com.appapplication.com.UserApplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{applicationId}")
public class UserApplicationController {


    private UserApplicationService userService;

    public UserApplicationController(UserApplicationService userService) {
        this.userService = userService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to User Controller";
    }


    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserApplication>> getAllUser(@PathVariable Long applicationId){

       List<UserApplication> userApplications= userService.getAllUser();
       return new ResponseEntity<>(userApplications, HttpStatus.OK);
    }

    @GetMapping("/getUserId/{userApplicationId}")
    public UserApplication getUserId(@PathVariable Long applicationId,@PathVariable Long userApplicationId){


         UserApplication userApplications= userService.getUserId(applicationId,userApplicationId);
        return userApplications;
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

    @PutMapping ("/updateUser/{userApplicationId}")
    public ResponseEntity<String> updateUser(@PathVariable Long applicationId,@PathVariable Long userApplicationId, @RequestBody UserApplication userApplication){

        boolean isUpdated=userService.updateUser(applicationId,userApplicationId,userApplication);
        if(isUpdated){
            return new ResponseEntity<>("User Updated Successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("User Not Updated", HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping ("/deleteUser/{userApplicationId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userApplicationId){

        boolean isdeleted=userService.deleteUser(userApplicationId);
        if(isdeleted){
            return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("User Not Deleted", HttpStatus.NOT_FOUND);
        }

    }

}
