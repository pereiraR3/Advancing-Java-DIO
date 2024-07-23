package org.example.domain.interfaces;

public interface NavegadorInternet {

    public void exibirPagina(String url);
    public void adicionarNovaAba(String url_nova);
    public void atualizarPagina(int pos, String url_nova);

}
