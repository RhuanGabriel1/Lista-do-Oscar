package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private final List<Actor> actor;
    private final List<Actor> actress;

    public FileReader(String fileNameActor, String fileNameActress) {
        this.actor = readFileMale(fileNameActor);
        this.actress = readFileFemale(fileNameActress);
    }

    public List<Actor> readFileMale(String fileNameActor){
        try(Stream<String> fileLines = Files.lines(Paths.get(fileNameActor))){
            return fileLines
                    .skip(1)
                    .map(Actor::of)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            return  Collections.emptyList();
        }
    }

    public List<Actor> readFileFemale(String fileNameActress){
        try(Stream<String> fileLines = Files.lines(Paths.get(fileNameActress))){
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
        return actor;
    }

    public List<Actor> getActress() {
        return actress;
    }

//    public List<Actor> retornaConcat(List<Actor> actor, List<Actor> actress ){
//        List<Actor> teste;
//        teste = actor.co
//
//        return
//    }
}
