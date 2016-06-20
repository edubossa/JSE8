package br.com.ews.jse8;

import br.com.ews.jse8.pojo.Turma;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wallace on 17/06/16.
 */
public class StreamTest3 {

    static void print(String msg) {
        System.out.println("//--------------------------------------------------------------------//");
        System.out.println("                <<< " + msg + " >>>");
        System.out.println();
    }

    public static void main(String[] args) {

        List<Turma> turmas = new ArrayList<>();
        turmas.add(new Turma("Sistema de Informacao", 50));
        turmas.add(new Turma("Direito", 150));
        turmas.add(new Turma("Medicina", 33));
        turmas.add(new Turma("Letras", 65));
        turmas.add(new Turma("Matematica", 12));
        turmas.add(new Turma("Fisica", 100));
        turmas.add(new Turma("Administracao", 200));

        int sum = turmas.stream().mapToInt(s -> s.getAlunos()).sum();
        print("Total alunos: " + sum);

        /*
        //Maior turma manualmente
        Turma temp = turmas.get(0);
        for(Turma t : turmas) {
            if(t.getAlunos() > temp.getAlunos()) {
                temp = t;
            }
        }*/
        //Maior turma com lambda
        Turma turma = turmas.stream().max(Comparator.comparing(Turma::getAlunos)).get();
        print("Maior turma: " + turma);

        print("Ordenar pela turma");
        List<Turma> turmaOrdenada = turmas.stream().sorted(Comparator.comparing(Turma::getTurma))
                .collect(Collectors.toList());
        turmaOrdenada.forEach(System.out::println);

        print("Turmas ate 100 alunos");
        turmas.stream().filter(t -> t.getAlunos() <= 100)
                .collect(Collectors.toList()).forEach(System.out::println);

        print("Filtrar os alunos da turma de Medicina");
        turmas.stream().filter(t -> t.getTurma().equals("Medicina"))
                .forEach(System.out::println);

    }

}
