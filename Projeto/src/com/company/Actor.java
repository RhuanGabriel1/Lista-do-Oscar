package com.company;

public class Actor {

    private Integer index, year, age;
    private String name, movie;


    public Actor(Integer index, Integer year, Integer age, String name, String movie) {
        this.index = index;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
    }

    public static Actor of(String line){
        return null;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "index=" + index +
                ", year=" + year +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", movie='" + movie + '\'' +
                '}';
    }
}
