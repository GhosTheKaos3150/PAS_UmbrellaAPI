package com.umbrella.umbrellaapi.API.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category/sub")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @GetMapping
    public ResponseEntity<List<Subscription>> getAll() {

        try{

            var sub = service.getAll();

            if (sub.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            return ResponseEntity.ok(sub);

        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Subscription>> getByCategory (@PathVariable ("id") int id){

        try{

            var sub = service.getByCategory(id);

            if (sub.isEmpty())
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok(sub);

        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/subscribe")
    public ResponseEntity addSubscription(@RequestBody Subscription body){

        try{

            var sub = service.save(body);

            if (sub == null)
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();

            return ResponseEntity.status(HttpStatus.CREATED).build();

        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/{id}/unsubscribe")
    public ResponseEntity deleteSubscription(@PathVariable("id") int id){

        try {

            var deleted = service.deleteById(id);

            if (deleted)
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();

            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();

        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
