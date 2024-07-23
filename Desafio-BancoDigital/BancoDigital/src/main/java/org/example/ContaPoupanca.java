package org.example;

public class ContaPoupanca extends Conta{


    public ContaPoupanca(Cliente cliente){
        super(cliente);
        super.agencia = Conta.AGENCIA_CONTA;
        super.numero = Conta.SEQUENCIAL++;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(" == Extrato de Conta Poupança == ");
        super.informacoesComuns();
    }
}
