package com.umbrella.umbrellaapi.API.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service){

        this.service = service;

    }

    //CRUD de Categorias

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
    public ResponseEntity<Category> getOne(@PathVariable ("id") int id){

        try{

            var category = service.getOne(id);

            return ResponseEntity.ok(category);

        }catch (Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

}
