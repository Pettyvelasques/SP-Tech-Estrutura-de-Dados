package sptech.school;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String T1[] = new String[10];
        int it1 = 0;
        String T2[] = new String[10];
        int it2 = 0;
        Scanner leitor = new Scanner(System.in);

        for (int i=0; i < 10; i++){
            System.out.println("Digite o nome do Aluno");
            String nome = leitor.nextLine();
            System.out.println("Digite a turma de " + nome);
            String turma = leitor.nextLine();

            if(turma.toLowerCase().equals("t1")){
                T1[it1] = nome;
                it1++;
            }else if(turma.toLowerCase().equals("t2")){
                T2[it2] = nome;
                it2++;
            }
        }

        System.out.println("A turma 01 tem "+ it1 + " alunos");
        for (int i = 0; i < it1; i++) {
            System.out.print(T1[i] + " ");
        }

        System.out.println("");
        System.out.println("A turma 02 tem "+ it2 + " alunos");
        for (int i = 0; i < it2; i++) {
            System.out.print(T2[i] + " ");
        }

    }
}