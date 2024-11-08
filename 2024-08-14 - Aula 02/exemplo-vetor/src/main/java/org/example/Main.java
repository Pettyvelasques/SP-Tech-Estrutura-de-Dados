package org.example;

import java.util.Scanner;

public class Main {

    public static void exibeVetor(int[] v){
        for(int i=0; i< v.length; i++){
            System.out.println("v[" + i + "] = " + v[i]);
        }
    }

    public static void leViOOsa(int[] v){

        Scanner leitor = new Scanner(System.in);

        for(int i=0; i< v.length; i++){
            System.out.println("Digite o valor de vetor["+i+"]");
            v[i] = leitor.nextInt();
        }
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

//        int[] vetor = new int[5];
//        int[] vetor2 = {100,200,300,400,500,600,700};
//        String[] vetor3 = new String[4];
//
//        int tamanho;
//        int[] vetor4;
//
//        for (int i=0; i < vetor.length; i++){
//            vetor[i] = i * 10;
//        }
//        System.out.println("Vetor: ");
//        exibeVetor(vetor);
//
//        leViOOsa(vetor);
//
//        System.out.println("\nVetor: ");
//        exibeVetor(vetor);
//
//        System.out.println("\nVetor 2: ");
//        exibeVetor(vetor2);
//
//        for(int i=0; i < vetor3.length; i++){
//            System.out.println("Digite o valor de vetor["+i+"]");
//            vetor3[i] = leitor.next();
//        }
//
//        System.out.println("\nVetor 3: ");
//        for(String s : vetor3){
//            System.out.println(s);
//        }
//
//        do{
//            System.out.println("Digite o valor do tamanho");
//            System.out.println("Esse valor deve ser maior ou igual a 3");
//            tamanho = leitor.nextInt();
//        } while (tamanho < 3);
//
//        vetor4 = new int[tamanho];
//
//        leViOOsa(vetor4);
//
//        System.out.println("\nVetor 4: ");
//        exibeVetor(vetor4);

        String[] vetorSemanal = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
        int numeroSemanal;
        do{
            System.out.println("Digite um número de 01 a 07");
            numeroSemanal = leitor.nextInt();
        } while (numeroSemanal < 1 || numeroSemanal > 7);
        System.out.println(numeroSemanal + " é " + vetorSemanal[numeroSemanal - 1]);


    }
}