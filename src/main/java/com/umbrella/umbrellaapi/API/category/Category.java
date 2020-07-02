package com.umbrella.umbrellaapi.API.category;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id @GeneratedValue private int id;
    @Column private String names;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }
}
