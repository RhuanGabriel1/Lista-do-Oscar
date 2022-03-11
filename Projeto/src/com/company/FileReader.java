package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private final List<Actor> actors;


    public FileReader(String fileNameActor, String fileNameActress) {
        this.actors = readFile(fileNameActor,fileNameActress);
    }

    public List<Actor> readFile(String fileNameActor, String fileNameActress){
        try(Stream<String> fileLines = Files.lines(Paths.get(fileNameActor, fileNameActress))){
            return fileLines
                    .skip(1)
                    .map(Actor::of)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            return  Collections.emptyList();
        }
    }

    public List<Actor> getActors() {
        return actors;
    }
}
