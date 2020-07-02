package com.umbrella.umbrellaapi.API.config;

import com.umbrella.umbrellaapi.API.category.Category;
import com.umbrella.umbrellaapi.API.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){

        try{

            var category = service.getAll();

            return ResponseEntity.ok(category);

        }catch (Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getOne(@PathVariable("id") int id){

        try{

            var category = service.getOne(id);

            return ResponseEntity.ok(category);

        }catch (Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    @PostMapping
    public ResponseEntity post(@RequestBody Category category){

        try{

            var temp = service.save(category);

            if (temp.getId() > 0)
                return ResponseEntity.status(HttpStatus.CREATED).build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }catch (Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable ("id") int id, @RequestBody Category category){

        try{

            service.put(id, category);

            return ResponseEntity.status(HttpStatus.CREATED).build();

        }catch (Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable ("id") int id){

        try{

            var temp = service.delete(id);

            if (temp)
                return ResponseEntity.accepted().build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }catch (Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

}
