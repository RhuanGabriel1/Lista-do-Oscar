package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    private static FileReader fileReader;

    public static void main(String[] args) {

        fileReader = new FileReader("male.csv", "female.csv");

        youngerActor();

        moreRepeated();

        moreRepeatedBetween();

        uniqueStruct();

        nameActor(" Katharine Hepburn");
    }

    //Ator mais jovem
    public static void youngerActor(){
        List<Actor> actor = fileReader.getActors();
        Optional<Actor> actorOptional = actor.stream().min(Comparator.comparing(Actor::getAge));
        actorOptional.ifPresent(it -> System.out.println("O ator mais jovem a ganhar o Oscar foi " + it.getName()+ " com " + it.getAge() + " anos"));
    }

    //Atriz que mais se repete
    public static  void moreRepeated(){
        Map<String , Long> actress = fileReader.getActress().stream()
                .map(Actor::getName)
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()));
        actress.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(act -> System.out.println("A atriz que mais vezes ganhou o Oscar foi " + act.getKey() + " com " + act.getValue() + " Oscars"));
    }

    //Atriz que mais se repete entre 20 e 30 anos
    public static void moreRepeatedBetween(){
        Map<String , Long> actress = fileReader.getActress().stream()
                .filter(a -> a.getAge()>=20 && a.getAge()<=30)
                .map(Actor::getName)
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()));
        actress.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(act -> System.out.println("A atriz que mais vezes ganhou o Oscar entre 20 e 30 anos foi" + act.getKey() + " com " + act.getValue() + " Oscars"));
    }

    //Todos os atores e atrizes que ganharam mais de 1 Oscars
    public static void uniqueStruct(){

        Map<String , Long> resultActor = fileReader.getActors().stream()
                .map(Actor::getName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> resultActress = fileReader.getActress().stream()
                .map(Actor::getName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Stream<Map.Entry<String, Long>> actorStream = resultActor.entrySet().stream().filter(a-> a.getValue()>1);
        Stream<Map.Entry<String, Long>> actressStream = resultActress.entrySet().stream().filter(a-> a.getValue()>1);

        Stream.concat(actorStream, actressStream).forEach(a -> System.out.println("Ator/Atriz" + a.getKey() + ", número de Oscars: " + a.getValue()));

    }

    //Resumindo informações do ator/atriz escolhido
    public static void nameActor(String name){
        List<Actor> actor = fileReader.getActors();
        List<Actor> actress = fileReader.getActress();

        List<Actor> allActors = Stream.concat(actor.stream(), actress.stream()).collect(Collectors.toList());

        Map<String , Long> resultActor = fileReader.getActors().stream()
                .map(Actor::getName)
                .filter(aName -> aName.equals(name))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> resultActress = fileReader.getActress().stream()
                .map(Actor::getName)
                .filter(aName -> aName.equals(name))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Stream<Map.Entry<String, Long>> actorResult = resultActor.entrySet().stream();
        Stream<Map.Entry<String, Long>> actressResult = resultActress.entrySet().stream();

        actorResult.forEach(a-> System.out.println("\nAtor/Atriz" + a.getKey() + " têm: " + a.getValue() + " Oscars"));
        actressResult.forEach(a-> System.out.println("\nAtor/Atriz" + a.getKey() + " têm: " + a.getValue() + " Oscars"));

        Stream<Actor> actorStream = allActors.stream().filter(a-> a.getName().equals(name));
        actorStream.forEach(a-> System.out.println("\nO Ator/Atriz" + a.getName() + " com " + a.getAge() +" anos" +  " ganhou o Oscar pelo filme" + a.getMovie() + " no ano de " + a.getYear()));

    }
}
