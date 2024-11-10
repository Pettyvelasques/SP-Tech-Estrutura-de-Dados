package sptech.school;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {


    List<Atleta> lista = new ArrayList<>();
    FilaObj<Atleta> fila = new FilaObj<>(10);
    PilhaObj<Integer> pilha = new PilhaObj<>(10);
    private int nextId = 100;

    public Repositorio(List<Atleta> lista) {
        this.lista = lista;
    }
    public Repositorio() {
        this.lista = new ArrayList<>(10);
    }

    public void salvar(Atleta atleta){
        atleta.setId(nextId);
        lista.add(atleta);
        pilha.push(atleta.getId());
        System.out.println("Atleta salvo com ID: " + nextId);
        nextId++;
    }

    public void deletar(int id){
        for (Atleta atleta: lista){
            if(atleta.getId() == id){
                lista.remove(atleta);
                pilha.pop();
                return;
            }
        }
        System.out.println("ID inexistente!");
    }

    public void exibir(){
        if(lista.size() != 0){
            for (Atleta atleta: lista){
                atleta.exibir();
            }
            pilha.exibir();
            fila.exibe();
        }
        else {
            System.out.println("Repositório vazio!");
            fila.exibe();
        }
    }

    public void desfazer(){
        if(!pilha.isEmpty()){
            int id = pilha.pop();
            deletar(id);
        }
        else{
            System.out.println("Não há nada a desfazer!");
        }
    }

    public void agendarSalvar(Atleta atleta){
        fila.insert(atleta);
        System.out.println("Atleta agendado para salvar!");
    }

    public void executarAgendado(int qtdOperacoes){
        if(!fila.isEmpty()){
            if(qtdOperacoes <= 0 || qtdOperacoes > fila.getTamanho()){
                System.out.println("Quantidade de operações inválida!");
                return;
            }
            for (int i = 0; i < qtdOperacoes; i++) {
                Atleta atleta = fila.poll();
                salvar(atleta);
            }
            System.out.println(qtdOperacoes + " Operações realizadas");
        }
        else {
            System.out.println("Não há operações agendadas");
        }
    }
}
