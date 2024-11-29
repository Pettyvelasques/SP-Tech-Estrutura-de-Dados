package sptech.school;

public class ListaLigadaOrdenada extends ListaLigada{
    private Node head;

    public ListaLigadaOrdenada() {
        this.head = getHead();
    }

    @Override
    public void insereNode(int valor) {
        Node and = new Node();
        Node atual = new Node();
        super.insereNode(valor);
    }

    @Override
    public Node buscaNodeAnt(int valor) {
        Node ant = null;
        Node atual = head.getNext();
        while (atual != null && atual.getInfo() <= valor){
            if(atual.getInfo() == valor){
                return ant;
            } else{
                atual = atual.getNext();
            }
        }
        return null;
    }

    @Override
    public Node buscaNode(int valor) {
        Node atual = head.getNext();
        while (atual != null && atual.getInfo() <= valor){
            if(atual.getInfo() == valor){
                return atual;
            } else{
                atual = atual.getNext();
            }
        }
        return null;
    }

    @Override
    public boolean removeNode(int valor) {
        return super.removeNode(valor);
    }
}
