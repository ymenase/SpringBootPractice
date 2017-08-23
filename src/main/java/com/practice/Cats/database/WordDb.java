package com.practice.Cats.database;

import com.practice.Cats.entities.Cat;

import java.util.HashMap;

public class WordDb extends HashMap<Integer, Cat> {


    private static int counter = -1;

    private static WordDb instance = new WordDb();

    private WordDb() {}

    public static WordDb getInstance() {
        return instance;
    }

    private int incrementCounter(){
        counter++;
        return counter;
    }

    public int getCounter() {
        return counter;
    }


    public Cat put(Cat value) {
        incrementCounter();
        return super.put(counter, value);
    }
}
