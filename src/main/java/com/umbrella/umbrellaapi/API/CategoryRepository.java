package com.umbrella.umbrellaapi.API;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    //Não deu pra testar se dá certo
    @Modifying
    @Query("INSERT INTO Subscription VALUES(1,2, :categoryId, :userEmail from Subscription)")
    boolean subscriptionByCategory(@Param("categoryId") int categoryId, @Param("userEmail") String userEmail);

}
