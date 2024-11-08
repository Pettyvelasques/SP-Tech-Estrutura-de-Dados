package org.example;

import java.util.Stack;

public class Main {

    public static boolean ehPalindromo(int[] vetor) {
        Pilha pilha = new Pilha[vetor.length / 2];
        int meio = vetor.length / 2;

        for (int i = 0; i < meio; i++) {
            pilha.push(vetor[i]);
        }

        for (int i = (vetor.length % 2 == 0 ? meio : meio + 1); i < vetor.length; i++) {
            if (vetor[i] != pilha.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void converteParaBinario(int num) {
        if (num == 0) {
            System.out.println(0);
            return;
        }

        int tamanhoPilha = (int) (Math.log(num) / Math.log(2)) + 1;
         Pilha pilha = new Pilha[tamanhoPilha];

        while (num > 0) {
            pilha.push(num % 2);
            num /= 2;
        }

        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop());
        }
        System.out.println();
    }

    public static String inverteFrase(String frase) {
        PilhaObj<Character> pilha = new PilhaObj<>(frase.length());
        for (char c : frase.toCharArray()) {
            pilha.push(c);
        }

        StringBuilder fraseInvertida = new StringBuilder();
        while (!pilha.isEmpty()) {
            fraseInvertida.append(pilha.pop());
        }
        return fraseInvertida.toString();
    }

    public static boolean verificaPalindromo(String texto) {
        PilhaObj<Character> pilha = new PilhaObj<>(texto.length());
        StringBuilder textoLimpo = new StringBuilder();

        for (char c : texto.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                textoLimpo.append(c);
                pilha.push(c);
            }
        }

        for (char c : textoLimpo.toString().toCharArray()) {
            if (c != pilha.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] vetor1 = {1, 3, 3, 1};
        int[] vetor2 = {10, 20, 30, 40};
        System.out.println("É palíndromo? " + ehPalindromo(vetor1)); // true
        System.out.println("É palíndromo? " + ehPalindromo(vetor2)); // false

        System.out.print("Número 9 em binário: ");
        converteParaBinario(9); // 1001
        System.out.print("Número 12 em binário: ");
        converteParaBinario(12); // 1100

        PilhaObj<String> pilhaDeStrings = new PilhaObj<>(3);
        pilhaDeStrings.push("Primeiro");
        pilhaDeStrings.push("Segundo");
        pilhaDeStrings.push("Terceiro");
        pilhaDeStrings.exibir();
        System.out.println("Desempilhando: ");
        while (!pilhaDeStrings.isEmpty()) {
            System.out.println(pilhaDeStrings.pop());
        }

        String frase = "A pilha do gato";
        System.out.println("Frase invertida: " + inverteFrase(frase));

        String textoPalindromo = "A torre da derrota";
        System.out.println("É palíndromo? " + verificaPalindromo(textoPalindromo));
    }
}