package com.appapplication.com.Category;

import com.appapplication.com.Application.Application;
import com.appapplication.com.Type.Type;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category/{applicationId}/{userApplicationId}")
public class CategoryController {


    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @GetMapping("/getAllCategory")
    public ResponseEntity<List<Category>> getAllCategory(){
        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/getCategory/{categoryId}")
    public ResponseEntity<Optional<Category>> getCategory(@PathVariable Long applicationId, @PathVariable Long userApplicationId, @PathVariable Long categoryId ){


       Optional<Category> getCategoryList = categoryService.getCategory(applicationId, userApplicationId, categoryId);

       if (getCategoryList.isPresent()) {
           return new ResponseEntity<>(getCategoryList,HttpStatus.OK);
       }else  {
           return new ResponseEntity<>(getCategoryList,HttpStatus.NOT_FOUND);
       }


    }

    @PostMapping("/addCategory")
    public ResponseEntity<String> addCategory(@PathVariable Long applicationId, @PathVariable Long userApplicationId ,@RequestBody Category category){
        boolean isSaved = categoryService.addCategory(applicationId,userApplicationId,category);
        if(isSaved){
            return  new ResponseEntity<>("Saved Successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Save Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCategory/{categoryId}")
    public ResponseEntity<String> updateCategory (@PathVariable Long applicationId, @PathVariable Long userApplicationId,@PathVariable Long categoryId ,@RequestBody Category category){

        boolean isUpdated= categoryService.updateCategory(applicationId,userApplicationId,categoryId,category);

        if (isUpdated){
            return  new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }else  {
            return new ResponseEntity<>("Updated Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteCategory/{categoryId}")
    public ResponseEntity<String> deleteCategory (@PathVariable Long applicationId, @PathVariable Long userApplicationId,@PathVariable Long categoryId){

        boolean isDeleted= categoryService.deleteCategory(applicationId,userApplicationId,categoryId);

        if (isDeleted){
            return  new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }else  {
            return new ResponseEntity<>("Deleted Failed", HttpStatus.BAD_REQUEST);
        }

    }


}
