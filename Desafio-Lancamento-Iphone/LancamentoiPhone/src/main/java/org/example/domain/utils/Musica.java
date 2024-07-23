package org.example.domain.utils;

public class Musica {

    private String nome;
    private double duracao;
    private GeneroMusical genero;

    public Musica(String nome, double duracao, GeneroMusical genero){
        this.nome = nome;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public GeneroMusical getGenero() {
        return genero;
    }

    public void setGenero(GeneroMusical genero) {
        this.genero = genero;
    }

}
