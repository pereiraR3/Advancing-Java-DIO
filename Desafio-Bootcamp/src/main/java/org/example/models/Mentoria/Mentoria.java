package org.example.models.Mentoria;

import org.example.models.Bootcamp.Bootcamp;
import org.example.models.Cursos.Cursos;
import org.example.models.Devs.Devs;

import java.util.List;

public class Mentoria extends Bootcamp implements AutorizacaoAcessos{

    private final String nomeMentor;
    private final double qtdaHorasMentoria;

    public Mentoria(String nomeBootcamp, List<Cursos> cursosList, String nomeMentor, double qtdaHorasMentoria) {
        super(nomeBootcamp, cursosList);
        this.nomeMentor = nomeMentor;
        this.qtdaHorasMentoria = qtdaHorasMentoria;
    }


    @Override
    public boolean validateAccess(Devs dev) {
        return this.getDevsMatriculados().stream().anyMatch(devs -> devs.getUsername().equals(dev.getUsername()));
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "nomeMentor='" + nomeMentor + '\'' +
                ", qtdaHorasMentoria=" + qtdaHorasMentoria +
                '}';
    }


}
