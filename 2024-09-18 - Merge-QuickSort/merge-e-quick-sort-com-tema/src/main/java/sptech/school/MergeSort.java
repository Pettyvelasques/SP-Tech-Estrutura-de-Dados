package sptech.school;

import java.util.Arrays;

public class MergeSort {

    public static void intercala(Atleta[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Atleta[] L = new Atleta[n1];
        Atleta[] R = new Atleta[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i].getPeso() <= R[j].getPeso()) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(Atleta[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            intercala(array, left, middle, right);
        }
    }

    public static void main(String[] args) {
        Atleta atleta1 = new Atleta(1, "João", "Silva", 78.5, 5);
        Atleta atleta2 = new Atleta(2, "Maria", "Oliveira", 62.3, 3);
        Atleta atleta3 = new Atleta(3, "Pedro", "Santos", 85.7, 7);
        Atleta atleta4 = new Atleta(4, "Ana", "Costa", 55.8, 2);
        Atleta atleta5 = new Atleta(5, "Carlos", "Pereira", 90.2, 10);
        Atleta atleta6 = new Atleta(6, "Julia", "Fernandes", 68.4, 4);

        Atleta[] atletas = {atleta1, atleta2, atleta3, atleta4, atleta5, atleta6};

        System.out.println("Array original: " + Arrays.toString(atletas));

        mergeSort(atletas, 0, atletas.length - 1);

        System.out.println("Array ordenado com MergeSort (por peso): " + Arrays.toString(atletas));
    }
}
