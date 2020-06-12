package com.umbrella.umbrellaapi.API;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {

    @Id @GeneratedValue private int id;
    @ManyToOne private Category category;
    @Column(nullable = false) private String title;
    @Column(nullable = false) private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
