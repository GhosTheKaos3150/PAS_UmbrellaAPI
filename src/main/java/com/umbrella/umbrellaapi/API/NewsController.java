package com.umbrella.umbrellaapi.API;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    private NewsService service;

    public NewsController(NewsService service) {
        this.service = service;

    }

    //CRUD das Noticias

    @GetMapping
    public ResponseEntity getAll() {
        try {

            var news = service.getAll();

            return ResponseEntity.ok(news);

        }catch(Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    //TODO: Erro no GetOne
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable("id") int id) {

        try {

            var news = service.get(id);

            return ResponseEntity.ok(news);

        }catch(Exception ex){

            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("/{title}")
    public ResponseEntity getByTitle(@PathVariable ("title") String title){

        try{

            var news = service.getByTitle(title);

            return ResponseEntity.ok(news);

        }catch (Exception ex){

            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    //Não deu pra testar, mas talvez dê erro
    @PostMapping("/{id}/addimage")
    public ResponseEntity addImage (@PathVariable ("id") int id, @RequestBody Image image){

        try{

            var temp = service.saveImage(service.get(id), image);

            if (temp)
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }catch (Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    //Está dando erro. Provavelmente porquê não estou sabendo formular o objeto Category dentro do objeto News
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

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody News body){
        try {

            service.put(id, body.getBody());

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();

        }catch (Exception ex){

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
