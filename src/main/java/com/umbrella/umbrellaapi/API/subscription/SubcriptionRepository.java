package com.umbrella.umbrellaapi.API.subscription;

import com.umbrella.umbrellaapi.API.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcriptionRepository extends JpaRepository <Subscription, Integer> {

    @Query ("FROM Subscription s WHERE s.category = :category")
    List<Subscription> findByCategory(@Param("category") Category category);

}
