package org.example;

public abstract class Conta extends Banco implements iConta {

    protected static final int AGENCIA_CONTA = 1101;
    protected static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo = 0;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_CONTA;
        this.numero = SEQUENCIAL++;
        super.addNovoCliente(cliente);
    }

    @Override
    public void sacar(double valor) throws IllegalArgumentException {
        if(valor > this.saldo)
            throw new IllegalArgumentException("Saldo insuficiente");
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) throws IllegalArgumentException {

        if(valor > this.saldo)
            throw new IllegalArgumentException("Saldo insuficiente");

        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void informacoesComuns() {
        System.out.printf("Agência: %d%n", this.agencia);
        System.out.printf("Número: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }



}
