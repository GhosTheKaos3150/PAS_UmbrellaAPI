package com.umbrella.umbrellaapi.API.config;

import com.umbrella.umbrellaapi.API.news.News;
import com.umbrella.umbrellaapi.API.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/news")
public class AdminNewsController {

    @Autowired
    private NewsService service;

    @GetMapping
    public ResponseEntity<List<News>> getAll() {
        try {

            var news = service.getAll();

            return ResponseEntity.ok(news);

        }catch(Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    //TODO: Erro no GetOne
    @GetMapping("/{id}")
    public ResponseEntity<News> getOne(@PathVariable("id") int id) {

        try {

            var news = service.get(id);

            return ResponseEntity.ok(news);

        }catch(Exception ex){

            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<News>> getByTitle(@PathVariable ("title") String title){

        try{

            var news = service.getByTitle(title);

            return ResponseEntity.ok(news);

        }catch (Exception ex){

            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    @PostMapping
    public ResponseEntity add(@RequestBody News body){
        try {

            var news = service.save(body);

            if (news.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }catch(Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        try {

            service.delete(id);

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();

        }catch (Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

}
