package com.umbrella.umbrellaapi.API.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    //Não deu pra testar se dá certo
    @Query("FROM News n WHERE n.title like %:title%")
    List<News> findNewsByTitle(@Param("title") String title);

    @Query("FROM News n WHERE n.id = :id")
    News findById(@Param("id") int id);

}
