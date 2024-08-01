package org.example.models.Bootcamp;

import org.example.models.Cursos.Cursos;
import org.example.models.Devs.Devs;

import java.util.ArrayList;
import java.util.List;

public abstract class Bootcamp {

    private final String nome;

    private final List<Cursos> cursosList;

    private double horas_totais;

    private List<Devs> devsMatriculados;

    public Bootcamp(String nome, List<Cursos> cursosList){

        this.nome = nome;
        this.cursosList = cursosList;
        this.horas_totais = 0.00;
        this.devsMatriculados = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + getNome() + '\'' +
                ", cursosList=" + getCursosList() +
                ", devsMatriculados=" + getDevsMatriculados() +
                ", horas_totais=" + getHoras_totais() +
                '}';
    }

    public void setHoras_totais(double horas_totais) {
        this.horas_totais += horas_totais;
    }

    public String getNome() {
        return nome;
    }

    public List<Cursos> getCursosList() {
        return cursosList;
    }

    public double getHoras_totais() {
        return horas_totais;
    }

    public List<Devs> getDevsMatriculados() {
        return devsMatriculados;
    }

    public void addDevsMatriculados(Devs dev) {
        this.devsMatriculados.add(dev);
    }

}
