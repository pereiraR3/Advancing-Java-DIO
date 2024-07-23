package org.example.domain.utils;

public class Contato {

    private String nome;
    private String telefone;
    private String apelido;

    public Contato(String nome, String telefone, String apelido) {
        this.nome = nome;
        this.telefone = telefone;
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

}
