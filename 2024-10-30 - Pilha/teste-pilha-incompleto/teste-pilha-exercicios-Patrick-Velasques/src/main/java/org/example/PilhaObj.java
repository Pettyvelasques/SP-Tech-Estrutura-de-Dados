package org.example;

public class PilhaObj<T> {
    private T[] pilha;
    private int topo;

    public PilhaObj(int capacidade) {
        pilha = (T[]) new Object[capacidade];
        topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == pilha.length - 1;
    }

    public void push(T elemento) {
        if (!isFull()) {
            pilha[++topo] = elemento;
        }
    }

    public T pop() {
        return isEmpty() ? null : pilha[topo--];
    }

    public T peek() {
        return isEmpty() ? null : pilha[topo];
    }

    public void exibir() {
        for (int i = topo; i >= 0; i--) {
            System.out.print(pilha[i] + " ");
        }
        System.out.println();
    }
}

