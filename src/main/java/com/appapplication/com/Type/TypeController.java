package com.appapplication.com.Type;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type/{applicationId}/{userApplicationId}")
public class TypeController {

    private TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Type Controller";
    }

    @PostMapping("/addType")
    public ResponseEntity<String> addType(@PathVariable Long applicationId, @PathVariable Long userApplicationId ,@RequestBody Type type){
        boolean isSaved = typeService.addType(applicationId,userApplicationId,type);
        if(isSaved){
            return  new ResponseEntity<>("Saved Successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Save Failed", HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/getAllType")
    public ResponseEntity<List<Type>> getAllType(){
        return new ResponseEntity<>(typeService.getAllType(),HttpStatus.OK);
    }

    @GetMapping("/getType/{usertypeId}")
    public ResponseEntity<List<Type>> getType(@PathVariable Long applicationId, @PathVariable Long userApplicationId,@PathVariable Long usertypeId ){
        return new ResponseEntity<>(typeService.getType(applicationId,userApplicationId,usertypeId),HttpStatus.OK);
    }
}
