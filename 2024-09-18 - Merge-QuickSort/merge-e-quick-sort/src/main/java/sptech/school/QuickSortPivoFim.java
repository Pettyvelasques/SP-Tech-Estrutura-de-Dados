package sptech.school;

import java.util.Arrays;

public class QuickSortPivoFim {
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = particiona(array, left, right);

            quickSort(array, left, pivotIndex - 1);

            quickSort(array, pivotIndex + 1, right);
        }
    }

    public static int particiona(int[] array, int left, int right) {
        int pivot = array[right];

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                trocar(array, i, j);
            }
        }

        trocar(array, i + 1, right);

        return i + 1;
    }

    public static void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array Original: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("Array Ordenado com QuickSort: " + Arrays.toString(array));
    }
}
