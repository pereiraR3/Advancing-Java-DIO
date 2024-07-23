package org.example.domain.interfaces;

import org.example.domain.utils.Musica;

public interface ReprodutorMusical {

    public void tocar(Musica musica);
    public void pausar();
    public void selecionarMusica(String nomeDaMusica);

}