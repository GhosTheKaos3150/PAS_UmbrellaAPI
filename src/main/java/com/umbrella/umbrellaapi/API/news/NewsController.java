package com.umbrella.umbrellaapi.API.news;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private NewsService service;

    public NewsController(NewsService service) {
        this.service = service;

    }

    //CRUD das Noticias

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

}
