package com.umbrella.umbrellaapi.API.subscription;

import com.umbrella.umbrellaapi.API.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubcriptionRepository repo;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Subscription> getAll(){

        return repo.findAll();

    }

    public List<Subscription> getByCategory(int categoryId) {

        return repo.findByCategory(categoryRepository.findById(categoryId));

    }

    public Subscription save(Subscription subscription) {

        return repo.save(subscription);

    }

    public boolean deleteById(int id){

        try {

            repo.deleteById(id);
            return true;

        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

}
