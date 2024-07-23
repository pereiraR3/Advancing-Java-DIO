package org.example;

public class ContaCorrente extends Conta{

   public ContaCorrente(Cliente cliente){
       super(cliente);
       super.agencia = Conta.AGENCIA_CONTA;
       super.numero = Conta.SEQUENCIAL++;
   }

    @Override
    public void imprimirExtrato() {
        System.out.println(" == Extrato de Conta Corrente == ");
        super.informacoesComuns();
    }
}
