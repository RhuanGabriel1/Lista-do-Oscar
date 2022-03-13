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
        String[] split = line.split(";");
        return new Actor(
                Integer.parseInt(split[0]),
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2]),
                split[3],
                split[4]
                );

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

    public Integer getYear() {
        return year;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getMovie() {
        return movie;
    }
}
