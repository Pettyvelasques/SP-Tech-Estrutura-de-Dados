package org.example;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);

        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);
        lista.adiciona(50);
        lista.adiciona(60);

        System.out.print("Elementos da lista: ");
        lista.exibe();

        System.out.println("Índice do elemento 30: " + lista.busca(30));
        System.out.println("Índice do elemento 60: " + lista.busca(60));

        lista.removePeloIndice(2);
        System.out.print("Lista após remover pelo índice 2: ");
        lista.exibe();

        lista.removeElemento(40);
        System.out.print("Lista após remover o elemento 40: ");
        lista.exibe();
    }
}