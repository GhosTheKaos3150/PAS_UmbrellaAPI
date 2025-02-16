package com.umbrella.umbrellaapi.API.image;

import com.umbrella.umbrellaapi.API.news.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query ("FROM Image i WHERE i.news = :news")
    List<Image> findImageById (@Param("news") News news);

}
