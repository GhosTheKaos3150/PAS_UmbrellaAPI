package com.umbrella.umbrellaapi.API;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    //Não deu pra testar se dá certo
    @Query("FROM News n WHERE n.title = :title")
    List<News> findNewsByTitle(@Param("title") String title);

    //Não deu pra testar se dá certo
    @Modifying
    @Query("INSERT INTO Image (news, source) select :news, :source from Image")
    void addImageTo(@Param("news") News news, @Param("source") String source);

}
