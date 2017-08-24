package com.practice.Cats.controllers;

import com.practice.Cats.dao.CatDAO;
import com.practice.Cats.entities.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cats")

@RestController
public class CatController {
    @Autowired
    CatDAO catDao;

    @PostMapping("") //get request
    public Cat add(@RequestParam String name){
        Cat cat = new Cat(name);
        return catDao.save(cat);
    }

    @GetMapping("")
    public Iterable<Cat> getAll(){
        return catDao.findAll();
    }

    @GetMapping("/{id}")
    public Cat getSingle(@PathVariable int id){
        return catDao.findOne(id);
    }


    @DeleteMapping("/{id}")
    public Cat delete(@PathVariable int id){
        Cat cat = catDao.findOne(id);
        catDao.delete(id);
        return cat;
    }

    @DeleteMapping("/delete")
    public void deleteAll() {
         catDao.deleteAll();
    }

    @PutMapping("/{id}/reverse")
    public Cat reverse(@PathVariable int id){
        Cat cat = catDao.findOne(id);
        String string = cat.getName();
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        cat.setName(sb.toString());
        return catDao.save(cat);
    }

    @PutMapping("/{id}")
    public Cat update(@PathVariable int id, @RequestParam String name){
        Cat cat = catDao.findOne(id);
        cat.setName(name);
        return catDao.save(cat);
    }


}
