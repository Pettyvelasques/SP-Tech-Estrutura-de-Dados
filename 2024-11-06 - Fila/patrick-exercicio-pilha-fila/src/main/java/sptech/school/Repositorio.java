package sptech.school;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {


    List<Atleta> lista = new ArrayList<>();
    FilaObj<Atleta> fila = new FilaObj<>(10);
    PilhaObj<Integer> pilha = new PilhaObj<>(10);

    public Repositorio(List<Atleta> lista) {
        this.lista = lista;
    }

    public void salvar(Atleta atleta){
    }

    public void deletar(){

    }
    public void exibir(){}
    public void desfazer(){}
    public void agendarSalvar(){}
    public void executarAgendado(){}
}
