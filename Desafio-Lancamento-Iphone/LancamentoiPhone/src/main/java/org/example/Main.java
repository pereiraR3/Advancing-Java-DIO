package org.example;

import org.example.domain.iphone.Iphone;
import org.example.domain.utils.Contato;
import org.example.domain.utils.GeneroMusical;
import org.example.domain.utils.Musica;
import org.example.domain.utils.Usuario;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Vinícius", "senha123", "vinicius@example.com");

        Iphone iphone = new Iphone("iPhone 13", "6.1 polegadas", 7999.99, usuario);

        iphone.exibirDetalhesGerais();

        Iphone.Navegador navegador = new Iphone.Navegador();
        navegador.adicionarNovaAba("http://example.com");
        navegador.adicionarNovaAba("http://example.org");
        navegador.atualizarPagina(1, "http://example.net");
        navegador.exibirPagina("http://example.com");

        Iphone.Musicas reprodutorMusical = new Iphone.Musicas();
        Musica musica1 = new Musica("Song 1", 3.5, GeneroMusical.ROCK);
        Musica musica2 = new Musica("Song 2", 4.0, GeneroMusical.POP);
        reprodutorMusical.setListaDeMusicas(List.of(musica1, musica2));
        reprodutorMusical.selecionarMusica("Song 1");
        reprodutorMusical.pausar();
        reprodutorMusical.tocar(musica2);

        Iphone.Contatos contatos = new Iphone.Contatos();
        Contato contato1 = new Contato("Alice", "12345", "Ally");
        Contato contato2 = new Contato("Bob", "67890", "Bobby");
        contatos.addListaDeContatos(contato1);
        contatos.addListaDeContatos(contato2);
        contatos.ligar("12345");
        contatos.atender("67890");
        contatos.atender("11111");

        boolean senhaCorreta = iphone.verificadorDeSenha("senha123");
        boolean emailCorreto = iphone.verificadorDeEmail("vinicius@example.com");
        System.out.println("Senha correta: " + senhaCorreta);
        System.out.println("Email correto: " + emailCorreto);
    }
}
