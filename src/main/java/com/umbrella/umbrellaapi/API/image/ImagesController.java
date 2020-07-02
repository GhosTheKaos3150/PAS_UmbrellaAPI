package com.umbrella.umbrellaapi.API.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news/img")
public class ImagesController {

    @Autowired
    private ImageService service;

    @GetMapping("/{id}/images")
    public ResponseEntity<List<Image>> getByNewsId (@PathVariable ("id") int newsId){

        try{

            var Images = service.getAllById(newsId);

            if (Images.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            return ResponseEntity.ok(Images);

        }catch (Exception e){

            System.out.println(e);
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    @PostMapping("/admin/addImage")
    public ResponseEntity postById (@RequestBody Image body){

        try {

            var image = service.save(body);

            if (image == null)
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

            return  ResponseEntity.status(HttpStatus.ACCEPTED).build();

        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
