package sptech.school;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(10);

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

        lista.substitui(20,21);
        System.out.print("Lista após substituir o elemento 20: ");
        lista.exibe();

        System.out.println("Total de repetições do número 20: " + lista.contaOcorrencias(20));

        lista.adicionaNoInicio(20);
        System.out.print("Lista após adicionar o elemento 20 no inicio do vetor: ");
        lista.exibe();



        ListaEstatica listaOrdenada = new ListaEstatica(10);

        listaOrdenada.adicaoOrdenada(10);
        System.out.print("Lista após adicionar o elemento 10 no vetor ordenado: ");
        listaOrdenada.exibe();

        listaOrdenada.adicaoOrdenada(2);
        System.out.print("Lista após adicionar o elemento 2 no vetor ordenado: ");
        listaOrdenada.exibe();

        listaOrdenada.adicaoOrdenada(40);
        System.out.print("Lista após adicionar o elemento 40 no vetor ordenado: ");
        listaOrdenada.exibe();

        listaOrdenada.adicaoOrdenada(3);
        System.out.print("Lista após adicionar o elemento 3 no vetor ordenado: ");
        listaOrdenada.exibe();

        listaOrdenada.adicaoOrdenada(5);
        System.out.print("Lista após adicionar o elemento 5 no vetor ordenado: ");
        listaOrdenada.exibe();


        listaOrdenada.adicaoOrdenada(60);
        System.out.print("Lista após adicionar o elemento 60 no vetor ordenado: ");
        listaOrdenada.exibe();
    }
}

