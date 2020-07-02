package com.umbrella.umbrellaapi.API.image;

import com.umbrella.umbrellaapi.API.news.NewsController;
import com.umbrella.umbrellaapi.API.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private ImageRepository imageRepository;
    @Autowired
    private NewsRepository newsRepository;

    public ImageService (ImageRepository imageRepository){

        this.imageRepository = imageRepository;

    }

    public List<Image> getAll(){

        return imageRepository.findAll();

    }

    //Precisa testar
    public List<Image> getAllById (int newsId){

        return imageRepository.findImageById(newsRepository.findById(newsId));

    }

    public Image save(Image image){

        return imageRepository.save(image);

    }

}
