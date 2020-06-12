package com.umbrella.umbrellaapi.API;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id @GeneratedValue private int id;
    @Column private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
