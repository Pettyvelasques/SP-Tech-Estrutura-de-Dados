package sptech.school;

import java.util.Arrays;

public class QuickSortPivoMeio {
    public static void quickSort(Atleta[] atletas, int left, int right) {
        if (left < right) {
            int pivotIndex = particiona(atletas, left, right);

            quickSort(atletas, left, pivotIndex - 1);
            quickSort(atletas, pivotIndex + 1, right);
        }
    }

    public static int particiona(Atleta[] atletas, int left, int right) {
        int middle = (left + right) / 2;
        double pivot = atletas[middle].getPeso();

        trocar(atletas, middle, right);

        int i = left;

        for (int j = left; j < right; j++) {
            if (atletas[j].getPeso() <= pivot) {
                trocar(atletas, i, j);
                i++;
            }
        }

        trocar(atletas, i, right);

        return i;
    }

    public static void trocar(Atleta[] atletas, int i, int j) {
        Atleta temp = atletas[i];
        atletas[i] = atletas[j];
        atletas[j] = temp;
    }

    public static void main(String[] args) {
        Atleta atleta1 = new Atleta(1, "João", "Silva", 78.5, 5);
        Atleta atleta2 = new Atleta(2, "Maria", "Oliveira", 62.3, 3);
        Atleta atleta3 = new Atleta(3, "Pedro", "Santos", 85.7, 7);
        Atleta atleta4 = new Atleta(4, "Ana", "Costa", 55.8, 2);
        Atleta atleta5 = new Atleta(5, "Carlos", "Pereira", 90.2, 10);
        Atleta atleta6 = new Atleta(6, "Julia", "Fernandes", 68.4, 4);

        Atleta[] atletas = {atleta1, atleta2, atleta3, atleta4, atleta5, atleta6};

        System.out.println("Atletas Original: " + Arrays.toString(atletas));

        quickSort(atletas, 0, atletas.length - 1);

        System.out.println("Atletas Ordenados pelo Peso: " + Arrays.toString(atletas));
    }
}
