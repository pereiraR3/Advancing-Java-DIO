package org.example.domain.iphone;

import org.example.domain.interfaces.AparelhoTelefonico;
import org.example.domain.interfaces.AutenticacaoIPhone;
import org.example.domain.interfaces.NavegadorInternet;
import org.example.domain.interfaces.ReprodutorMusical;
import org.example.domain.utils.Contato;
import org.example.domain.utils.Musica;
import org.example.domain.utils.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Iphone implements AutenticacaoIPhone {

    private final String modelo;
    private final String tamanho;
    private final double preco;
    private final Usuario usuario;

    public Iphone(String modelo, String tamanho, double preco, Usuario usuario) {
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.preco = preco;
        this.usuario = usuario;
    }

    /**
     * Métodos próprios da classe Iphone
     */
    public void exibirDetalhesGerais() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Tamanho: " + tamanho);
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());
    }

    /**
     * Subclasse - Navegador
     */
    public static class Navegador implements NavegadorInternet {

        private List<String> abas;
        private int numeroAbas;

        public Navegador() {
            this.numeroAbas = 0;
            this.abas = new ArrayList<>();
        }

        @Override
        public void exibirPagina(String url) throws IllegalArgumentException {
            if (this.verificadorDeUrl(url))
                System.out.println("Exibindo a url: " + url);
        }

        @Override
        public void adicionarNovaAba(String urlNova) {
            this.verificadorDeUrl(urlNova);
            this.abas.add(urlNova);
            this.numeroAbas = this.abas.size();
        }

        @Override
        public void atualizarPagina(int pos, String urlNova) {
            this.verificadorDeUrl(urlNova);
            this.abas.set(pos, urlNova);
        }

        public List<String> getAbas() {
            return abas;
        }

        public int getNumeroAbas() {
            return numeroAbas;
        }

        public boolean verificadorDeUrl(String url) throws IllegalArgumentException {
            if (url.isBlank() || url.isEmpty())
                throw new IllegalArgumentException("Url inválida");
            return true;
        }
    }

    /**
     * Subclasse - ReprodutorMusical
     */
    public static class Musicas implements ReprodutorMusical {

        private List<Musica> listaDeMusicas;
        private Musica musicaTocando;

        public Musicas() {
            this.listaDeMusicas = new ArrayList<>();
            this.musicaTocando = null;
        }

        @Override
        public void tocar(Musica musica) {
            this.musicaTocando = musica;
            System.out.println("Tocando a música - " + musica.getNome());
        }

        @Override
        public void pausar() throws IllegalArgumentException {
            if (musicaTocando == null)
                throw new IllegalArgumentException("Nenhuma música está tocando");
            System.out.println("Pausando a música - " + musicaTocando.getNome());
        }

        @Override
        public void selecionarMusica(String nomeDaMusica) {
            for (Musica musica : listaDeMusicas) {
                if (musica.getNome().equals(nomeDaMusica)) {
                    tocar(musica);
                    return;
                }
            }
            throw new IllegalArgumentException("Música não encontrada");
        }

        public List<Musica> getListaDeMusicas() {
            return listaDeMusicas;
        }

        public void setListaDeMusicas(List<Musica> listaDeMusicas) {
            this.listaDeMusicas = listaDeMusicas;
        }

        public Musica getMusicaTocando() {
            return musicaTocando;
        }
    }

    /**
     * Subclasse - Contatos
     */
    public static class Contatos implements AparelhoTelefonico {

        private List<Contato> listaDeContatos;
        private Map<String, String> historicoDeLigacoes;

        public Contatos() {
            this.listaDeContatos = new ArrayList<>();
            this.historicoDeLigacoes = new HashMap<>();
        }

        @Override
        public void ligar(String numero) throws IllegalArgumentException {
            for (Contato contato : listaDeContatos) {
                if (contato.getTelefone().equals(numero)) {
                    System.out.println("Ligando para " + contato.getNome());
                    return;
                }
            }
            throw new IllegalArgumentException("Você não tem esse número");
        }

        @Override
        public void atender(String telefone) {
            for (Contato contato : listaDeContatos) {
                if (contato.getTelefone().equals(telefone)) {
                    this.addHistoricoDeLigacoes(contato.getTelefone(), contato.getNome());
                    System.out.println("Atendendo ligação de " + contato.getNome());
                    return;
                }
            }
            this.addHistoricoDeLigacoes(telefone, "Desconhecido");
            System.out.println("Atendendo ligação de número desconhecido");
        }

        public void addListaDeContatos(Contato contatoNovo) {
            this.listaDeContatos.add(contatoNovo);
        }

        public List<Contato> getListaDeContatos() {
            return listaDeContatos;
        }

        public void addHistoricoDeLigacoes(String telefone, String nome) {
            this.historicoDeLigacoes.put(telefone, nome);
        }

        public Map<String, String> getHistoricoDeLigacoes() {
            return historicoDeLigacoes;
        }
    }

    /**
     * Sobrescrevendo os métodos da Interface AutenticacaoIPhone
     */
    @Override
    public boolean verificadorDeSenha(String senha) {
        return this.usuario.getSenha().equals(senha);
    }

    @Override
    public boolean verificadorDeEmail(String email) {
        return this.usuario.getEmail().equals(email);
    }

    /**
     * Apenas os Getters
     */
    public String getModelo() {
        return modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
