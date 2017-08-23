package com.practice.Cats.dao;

import com.practice.Cats.database.WordDb;
import com.practice.Cats.entities.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatDAO extends CrudRepository<Cat, Integer>{
    WordDb database = WordDb.getInstance();


}
