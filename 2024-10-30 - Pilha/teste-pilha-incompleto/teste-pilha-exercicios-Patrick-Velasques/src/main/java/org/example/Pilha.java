package org.example;

public class Pilha {

    // 01) Atributos
    private int[] pilha;
    private int topo;


    // 02) Construtor
    public Pilha(int[] pilha, int topo) {
        this.pilha = pilha;
        this.topo = topo;
    }
    public Pilha(int tamanho) {
        this.pilha = new int[tamanho];
        this.topo = -1;
    }

    // 03) MÃ©todo isEmpty
    public Boolean isEmpty() {
        return topo == -1;
    }

    // 04) MÃ©todo isFull
    public Boolean isFull() {
        return topo == pilha.length -1;
    }

    // 05) MÃ©todo push
    public void push(int info) {
        if(topo == pilha.length -1){
            throw new IllegalStateException("Pilha Cheia!");
        }
         pilha[++topo] = info;
    }

    // 06) MÃ©todo pop
    public int pop() {
        if(isEmpty()){
            return topo;
        }
        return pilha[topo--];
    }

    // 07) MÃ©todo peek
    public int peek() {
        if(isEmpty()) {
            return topo;
        }
        if(pilha.length == 1){
            return pilha[topo -1];
        }
        return pilha[topo];
    }

    // 08) MÃ©todo exibe
    public void exibe() {
        StringBuilder retorno = new StringBuilder("{ ");
        for (int i = 0; i <= topo; i++) {
            retorno.append(pilha[i]).append(" ");
        }
        retorno.append("}");
        System.out.println(retorno);
    }

    public String exibeEscrito() {
        StringBuilder retorno = new StringBuilder("{ ");
        for (int i = 0; i <= topo; i++) {
            retorno.append(pilha[i]).append(" ");
        }
        retorno.append("}");
        return retorno.toString();
    }


    //Getters & Setters (manter)
    public int getTopo() {
        return topo;
    }
}