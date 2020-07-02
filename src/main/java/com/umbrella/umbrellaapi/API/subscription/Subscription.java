package com.umbrella.umbrellaapi.API.subscription;

import com.umbrella.umbrellaapi.API.category.Category;

import javax.persistence.*;

@Entity
@Table(name = "subscription")
public class Subscription {

    @Id @GeneratedValue private int id;
    @ManyToOne private Category category;
    @Column private String user_email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory_id() {
        return category;
    }

    public void setCategory_id(Category category_id) {
        this.category = category_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
