package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int x = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > x) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = x;
        }
    }

    public static int pesquisaBinaria(int valorPesquisado, int[] vetor){
        int inicio = 0;
        int fim = vetor.length - 1;
        while (inicio <= fim){
            int meio = (inicio + fim) / 2;
            if(vetor[meio] == valorPesquisado){
                return meio;
            }
            else if(valorPesquisado >= vetor[meio]){
                inicio = meio + 1;
            }
            else{
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] vetor = {4,7,5,2,8,1,6,3};
        insertionSort(vetor);
        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));
        System.out.println("Pesquisa Binária " + pesquisaBinaria(0,vetor));
    }
}