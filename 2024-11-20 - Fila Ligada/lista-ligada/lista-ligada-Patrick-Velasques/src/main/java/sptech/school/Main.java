package sptech.school;

public class Main {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        System.out.println("Inserindo valores...");
        lista.insereNode(5);
        lista.insereNode(10);
        lista.insereNode(15);
        System.out.print("Lista após inserções: ");
        lista.exibe();

        System.out.println("\nBuscando valores...");
        System.out.println("Busca por 10: " + (lista.buscaNode(10) != null ? "Encontrado" : "Não encontrado"));
        System.out.println("Busca por 20: " + (lista.buscaNode(20) != null ? "Encontrado" : "Não encontrado"));

        System.out.println("\nRemovendo valores...");
        System.out.println("Removendo 10: " + (lista.removeNode(10) ? "Removido" : "Não encontrado"));
        System.out.println("Removendo 20: " + (lista.removeNode(20) ? "Removido" : "Não encontrado"));
        System.out.print("Lista após remoções: ");
        lista.exibe();

        System.out.println("\nTamanho da lista: " + lista.getTamanho());
    }



}