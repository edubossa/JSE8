package br.com.ews.jse8;

import br.com.ews.jse8.pojo.Developer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wallace on 20/06/16.
 */
public class FlatMapTest {

    public static void main(String[] args) {

        Developer gateway = new Developer("Gateway");
        gateway.add("Java");
        gateway.add("JQuery");
        gateway.add("Angular");
        gateway.add("Scala");
        gateway.add("Shell");

        Developer vaccine = new Developer("Vaccine");
        vaccine.add("Java");
        vaccine.add("JS");
        vaccine.add("JQuery");

        Developer ntkOnline = new Developer("NTK Online");
        ntkOnline.add("PHP");
        ntkOnline.add("SQL");
        ntkOnline.add("JQuery");

        List<Developer> team = new ArrayList<>();
        team.add(gateway);
        team.add(vaccine);
        team.add(ntkOnline);

        System.out.println("Agrupando todas as linguagens dos times!");

        List<String> teamLanguages = team.stream().map(d -> d.getLanguages()).flatMap(l -> l.stream())
                .distinct() //Usado para nao duplicar os dados
                .collect(Collectors.toList());

        teamLanguages.forEach(System.out::println);

    }

}
