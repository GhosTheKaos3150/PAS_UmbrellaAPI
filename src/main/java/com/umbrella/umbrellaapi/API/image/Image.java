package com.umbrella.umbrellaapi.API.image;

import com.umbrella.umbrellaapi.API.news.News;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id @GeneratedValue private int id;
    @ManyToOne private News news;
    @Column private String source;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public News getNews_id() {
        return news;
    }

    public void setNews_id(News news_id) {
        this.news = news_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
