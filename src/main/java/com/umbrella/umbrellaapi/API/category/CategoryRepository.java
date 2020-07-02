package com.umbrella.umbrellaapi.API.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("FROM Category c WHERE c.id = :id")
    Category findById (@Param("id") int id);

}
