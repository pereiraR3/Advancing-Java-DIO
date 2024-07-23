package org.example.domain.utils;

public class Usuario {

    private String nome;
    private final String senha;
    private final String email;

    public Usuario(String nome, String senha, String email) throws  IllegalArgumentException{

        if (nome.isBlank() || senha.isBlank() || email.isBlank()) {
            throw new IllegalArgumentException("Credenciais inválidas");
        }

        this.nome = nome;
        this.senha = senha;
        this.email = email;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

}
