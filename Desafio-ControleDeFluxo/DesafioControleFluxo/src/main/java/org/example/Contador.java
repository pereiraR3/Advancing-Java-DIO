package org.example;

import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {

        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt();
        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt();

        try {

            contar(parametroUm, parametroDois);

        }catch (IllegalArgumentException exception) {
            //imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
            System.out.println(exception.getMessage());
        }

    }
    static void contar(int parametroUm, int parametroDois ) throws IllegalArgumentException {
        //validar se parametroUm é MAIOR que parametroDois e lançar a exceção

        if(parametroUm > parametroDois)
            throw new IllegalArgumentException("O valor do primeiro parâmetro deve ser menor que o segundo");

        int contagem = parametroDois - parametroUm;
        //realizar o for para imprimir os números com base na variável contagem
        for (int i = 0; i < contagem; i++){
            System.out.println(i);
        }
    }
}