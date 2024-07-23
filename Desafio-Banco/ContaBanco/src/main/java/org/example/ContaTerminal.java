package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {

        int numero;
        String agencia, nomeCliente;
        double saldo;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, digite o número da conta!");
        numero = scanner.nextInt();

        // Consumir a nova linha pendente após nextInt()
        scanner.nextLine();

        System.out.println("Por favor, digite a agência!");
        agencia = scanner.nextLine();

        System.out.println("Por favor, o seu nome!");
        nomeCliente = scanner.nextLine();

        System.out.println("Por favor, digite o seu saldo!");
        saldo = scanner.nextDouble();

        BigDecimal bd = BigDecimal.valueOf(saldo);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        double saldoArredondado = bd.doubleValue();

        String mensagem = String.format("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.",
                nomeCliente, agencia, numero, saldoArredondado);

        System.out.println(mensagem);

        scanner.close();
    }
}
