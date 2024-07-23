package org.example;

public class Main {

    public static void main(String[] args) {
        // Criar clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria Santos");

        // Criar contas para os clientes
        Conta contaCorrenteJoao = new ContaCorrente(cliente1);
        Conta contaPoupancaMaria = new ContaPoupanca(cliente2);

        // Realizar algumas operações
        System.out.println("Depósito na conta de João:");
        contaCorrenteJoao.depositar(3000);
        contaCorrenteJoao.imprimirExtrato();

        System.out.println("\nDepósito na conta de Maria:");
        contaPoupancaMaria.depositar(1500);
        contaPoupancaMaria.imprimirExtrato();

        System.out.println("\nTransferência de João para Maria:");
        try {
            contaCorrenteJoao.transferir(1000, contaPoupancaMaria);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Imprimir extratos após a transferência
        contaCorrenteJoao.imprimirExtrato();
        contaPoupancaMaria.imprimirExtrato();
    }
}
