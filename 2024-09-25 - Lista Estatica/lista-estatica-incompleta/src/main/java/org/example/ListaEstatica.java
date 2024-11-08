package org.example;

import java.util.Arrays;

public class ListaEstatica {
    private int[] vetor;
    private int nroElem;

    public ListaEstatica(int tamanho) {
        vetor = new int[tamanho];
        nroElem = 0;
    }

    public void adiciona(int elemento) {
        if (nroElem >= vetor.length) {
//            System.out.println("Lista cheia");
            throw new IllegalStateException("Lista cheia");
        } else {
            vetor[nroElem] = elemento;
            nroElem++;
        }
    }

    public void exibe() {
        if (nroElem == 0) {
            System.out.println("Lista vazia");
        } else {
            for (int i = 0; i < nroElem; i++) {
                System.out.print(vetor[i] + " ");
            }
            System.out.println();
        }
    }

    public int busca(int elemento) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return false;
        }
        for (int i = indice; i < nroElem - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        nroElem--;
        return true;
    }

    public boolean removeElemento(int elemento) {
        int indice = busca(elemento);
        if (indice == -1) {
            return false;
        }
        return removePeloIndice(indice);
    }

    public int getNroElem() {
        return nroElem;
    }

    public int[] getVetor() {
        return vetor;
    }
}
