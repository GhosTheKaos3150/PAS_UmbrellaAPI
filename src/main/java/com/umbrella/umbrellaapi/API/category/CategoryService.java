package com.umbrella.umbrellaapi.API.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){

        this.categoryRepository = categoryRepository;

    }

    public List<Category> getAll(){
        return categoryRepository.findAll();

    }

    public Category getOne(int id){
        return categoryRepository.getOne(id);

    }

    public Category save(Category category){
        return categoryRepository.save(category);

    }

    public void put(int id,  Category category){

        var temp = categoryRepository.getOne(id);

        temp.setNames(category.getNames());

    }

    public boolean delete(int id){

        try{
            categoryRepository.deleteById(id);

            return true;
        }catch (Exception ex){

            return false;
        }

    }

}
