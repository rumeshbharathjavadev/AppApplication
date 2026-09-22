package com.appapplication.com.Application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {


    private ApplicationSevice applicationSevice;


    public ApplicationController(ApplicationSevice applicationSevice) {
        this.applicationSevice = applicationSevice;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Application Controller";
    }


    @PostMapping("/addApplication")
    public ResponseEntity<Application> addApplication(@RequestBody Application application) {

        Application application1 = applicationSevice.addApplication(application);
        return new ResponseEntity<>(application1, HttpStatus.CREATED);
    }


    @GetMapping("/getAllApplication")
    public ResponseEntity<List<Application>> getAllApplication (){
        List<Application> applications= applicationSevice.getAllApplication();
       return new ResponseEntity<>(applications,HttpStatus.OK);
    }


    @GetMapping("/getApplication/{id}")
    public ResponseEntity<Application> getApplication (@PathVariable Long id){
        Application application= applicationSevice.getApplication(id);
        if (application!=null){
            return new ResponseEntity<>(application,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateApplication/{id}")
    public ResponseEntity<String> updateApplication(@PathVariable Long id, @RequestBody Application application){
        boolean isUpdatedApplication= applicationSevice.updateApplication(id, application);
        if (isUpdatedApplication){
            return new ResponseEntity<>("App Application Updated successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("App Application Not Update",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteApplication/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id){
        boolean isDeletedApplication= applicationSevice.deleteApplication(id);
        if (isDeletedApplication){
            return new ResponseEntity<>("App Application Deleted successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("App Application Not Deleted",HttpStatus.NOT_FOUND);
        }
    }
}
