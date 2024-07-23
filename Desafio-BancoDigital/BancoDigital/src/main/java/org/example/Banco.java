package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Banco {

    protected static final String nome = "Bradesco";
    protected List<Cliente> clienteList;

    public Banco(){
        this.clienteList = new ArrayList<>();
    }

    public Cliente buscarCliente(Cliente cliente) {
        return this.clienteList.stream().filter(clienteList -> clienteList.getNome().equals(clienteList.getNome()))
                .findFirst()
                .orElse(null);
    }

    public void addNovoCliente(Cliente cliente) {
        this.clienteList.add(cliente);
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public String getNome() {
        return nome;
    }


}
