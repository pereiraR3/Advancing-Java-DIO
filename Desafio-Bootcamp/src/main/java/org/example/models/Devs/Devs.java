package org.example.models.Devs;

public class Devs {

    private final String username;
    private final String password;
    private final String email;
    private final String cpf;

    public Devs(String username, String password, String email, String cpf) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Dev {" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

}
