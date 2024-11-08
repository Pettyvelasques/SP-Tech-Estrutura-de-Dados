public class QuickSort {
    public static void quickSortMeio(int[] v, int indInicio, int indFim) {
        if (indInicio < indFim) {
            int pi = particiona(v, indInicio, indFim);

            quickSortMeio(v, indInicio, pi - 1);
            quickSortMeio(v, pi, indFim);
        }
    }

    public static int particiona(int[] v, int indInicio, int indFim) {
        int pivo = v[(indInicio + indFim) / 2]; 
        int i = indInicio;
        int j = indFim;

        while (i <= j) {
            while (i < indFim && v[i] < pivo) {
                i++;
            }
            while (j > indInicio && v[j] > pivo) {
                j--;
            }
            if (i <= j) {
                trocar(v, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    public static void trocar(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    public static void quickSortUltimo(int[] v, int indInicio, int indFim) {
        if (indInicio < indFim) {
            int pi = particionaUltimo(v, indInicio, indFim);

            quickSortUltimo(v, indInicio, pi - 1);
            quickSortUltimo(v, pi + 1, indFim);
        }
    }

    public static int particionaUltimo(int[] v, int indInicio, int indFim) {
        int pivo = v[indFim];
        int i = indInicio - 1;

        for (int j = indInicio; j < indFim; j++) {
            if (v[j] < pivo) {
                i++;
                trocar(v, i, j);
            }
        }
        trocar(v, i + 1, indFim);
        return i + 1;
    }

    public static void trocar2(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}

