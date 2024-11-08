package org.example;

import java.util.Arrays;

public class Main {
    public static void ordenador(int[] vetor){
        int troca = 0;
        int comparacao = 0;
        for (int i = 0; i < vetor.length-1; i++) {
            for (int j = i+1; j < vetor.length; j++) {
                comparacao++;
                if (vetor[i] > vetor[j]) {
                    troca++;
                    int aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
        System.out.println("Comparou "+ comparacao + " vezes");
        System.out.println("Trocou "+ troca + " vezes");
    }

    public static void selectionSort(int[] vetor){
        int troca = 0;
        int comparacao = 0;
        for (int i = 0; i < vetor.length-1; i++) {
            int imenor = i;
            for (int j = i+1; j < vetor.length; j++) {
                comparacao++;
                if (vetor[imenor] > vetor[j]) {
                    imenor = j;
                }
            }
            troca++;
            int aux = vetor[i];
            vetor[i] = vetor[imenor];
            vetor[imenor] = aux;
        }
        System.out.println("Comparou "+ comparacao + " vezes");
        System.out.println("Trocou "+ troca + " vezes");
    }

    public static void bubbleSort(int[] vetor){
        int troca = 0;
        int comparacao = 0;
        for (int i = 0; i < vetor.length-1; i++) {
            for (int j = 1; j < vetor.length-i; j++) {
                comparacao++;
                if (vetor[j-1] > vetor[j]) {
                    troca++;
                    int aux = vetor[j];
                    vetor[j] = vetor[j-1];
                    vetor[j-1] = aux;
                }
            }
        }
        System.out.println("Comparou "+ comparacao + " vezes");
        System.out.println("Trocou "+ troca + " vezes");
    }

    public static void main(String[] args) {
        int[] vetor = {4,7,5,2,8,1,6,3};
        ordenador(vetor);
        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));

        int[] vetorSelection = {4,7,5,2,8,1,6,3};
        selectionSort(vetorSelection);
        System.out.println("Vetor selection: " + Arrays.toString(vetorSelection));

        int[] vetorBubble = {4,7,5,2,8,1,6,3};
        bubbleSort(vetorBubble);
        System.out.println("Vetor bublle: " + Arrays.toString(vetorBubble));
    }
}