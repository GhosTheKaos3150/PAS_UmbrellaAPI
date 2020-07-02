package com.umbrella.umbrellaapi.API.news;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private NewsRepository newsRepo;

    public NewsService(NewsRepository repository){

        this.newsRepo = repository;

    }

    public News save(News news){

        return newsRepo.save(news);
    }

    public List<News> getAll() {

        return newsRepo.findAll();
    }

    public News get(int id) {

        return newsRepo.findById(id);

    }

    //Não deu pra testar se dá certo
    public List<News> getByTitle(String title){

        return newsRepo.findNewsByTitle(title);

    }

    public boolean delete(int id){

        try{
            newsRepo.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }

    }

}
