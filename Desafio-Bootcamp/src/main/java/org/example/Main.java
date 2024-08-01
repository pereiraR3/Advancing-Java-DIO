package org.example;

import org.example.models.Bootcamp.Bootcamp;
import org.example.models.Cursos.Cursos;
import org.example.models.Devs.Devs;
import org.example.models.Mentoria.Mentoria;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando cursos
        Cursos cursoJava = new Cursos("Java Básico", 10);
        Cursos cursoSpring = new Cursos("Spring Framework", 15);
        List<Cursos> cursosList = new ArrayList<>();
        cursosList.add(cursoJava);
        cursosList.add(cursoSpring);

        // Criando desenvolvedores
        Devs dev1 = new Devs("dev1", "password1", "dev1@example.com", "11111111111");
        Devs dev2 = new Devs("dev2", "password2", "dev2@example.com", "22222222222");

        // Criando um bootcamp de mentoria
        Bootcamp mentoriaBootcamp = new Mentoria("Bootcamp Java", cursosList, "Mentor", 20);

        // Matriculando desenvolvedores no bootcamp
        mentoriaBootcamp.addDevsMatriculados(dev1);
        mentoriaBootcamp.addDevsMatriculados(dev2);

        // Imprimindo detalhes do bootcamp
        System.out.println(mentoriaBootcamp);

        // Validando acesso dos desenvolvedores
        boolean acessoDev1 = ((Mentoria) mentoriaBootcamp).validateAccess(dev1);
        boolean acessoDev2 = ((Mentoria) mentoriaBootcamp).validateAccess(dev2);
        Devs dev3 = new Devs("dev3", "password3", "dev3@example.com", "33333333333");
        boolean acessoDev3 = ((Mentoria) mentoriaBootcamp).validateAccess(dev3);

        // Imprimindo os resultados da validação de acesso
        System.out.println("Acesso para dev1: " + acessoDev1); // true
        System.out.println("Acesso para dev2: " + acessoDev2); // true
        System.out.println("Acesso para dev3: " + acessoDev3); // false
    }
}
