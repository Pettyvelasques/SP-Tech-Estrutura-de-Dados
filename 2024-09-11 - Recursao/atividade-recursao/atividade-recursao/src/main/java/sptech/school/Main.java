package sptech.school;

public class Main {
    public static int somaIterativa(int n) {
        int soma = 0;
        for (int i = 0; i <= n; i++) {
            soma += i;
        }
        return soma;
    }
    public static int somaRecursiva(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + somaRecursiva(n - 1);
        }
    }


    public static int somaVetorIterativa(int[] vetor) {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }
        return soma;
    }
    public static int somaVetorRecursiva(int[] vetor, int i) {
        if (i >= vetor.length) {
            return 0;
        } else {
            return vetor[i] + somaVetorRecursiva(vetor, i + 1);
        }
    }


    public static int somaParesIterativa(int[] vetor) {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                soma += vetor[i];
            }
        }
        return soma;
    }
    public static int somaParesRecursiva(int[] vetor, int i) {
        if (i >= vetor.length) {
            return 0;
        } else {
            return (vetor[i] % 2 == 0 ? vetor[i] : 0) + somaParesRecursiva(vetor, i + 1);
        }
    }


    public static int quantImparesIterativa(int[] vetor) {
        int count = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }
    public static int quantImparesRecursiva(int[] vetor, int i) {
        if (i >= vetor.length) {
            return 0;
        } else {
            return (vetor[i] % 2 != 0 ? 1 : 0) + quantImparesRecursiva(vetor, i + 1);
        }
    }


    public static int quantOcorrenciasIterativa(int[] vetor, int x) {
        int count = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == x) {
                count++;
            }
        }
        return count;
    }
    public static int quantOcorrenciasRecursiva(int[] vetor, int x, int i) {
        if (i >= vetor.length) {
            return 0;
        } else {
            return (vetor[i] == x ? 1 : 0) + quantOcorrenciasRecursiva(vetor, x, i + 1);
        }
    }


    public static int mdcIterativo(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int mdcRecursivo(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return mdcRecursivo(b, a % b);
        }
    }


    public static int maiorElementoIterativo(int[] vetor) {
        int max = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > max) {
                max = vetor[i];
            }
        }
        return max;
    }
    public static int maiorElementoRecursivo(int[] vetor, int i, int max) {
        if (i >= vetor.length) {
            return max;
        } else {
            return maiorElementoRecursivo(vetor, i + 1, Math.max(max, vetor[i]));
        }
    }


    public static int somaDigitosIterativa(int n) {
        int soma = 0;
        while (n > 0) {
            soma += n % 10;
            n /= 10;
        }
        return soma;
    }
    public static int somaDigitosRecursiva(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n % 10 + somaDigitosRecursiva(n / 10);
        }
    }


    public static String representacaoBinariaIterativa(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
    public static String representacaoBinariaRecursiva(int n) {
        if (n == 0) {
            return "";
        }
        return representacaoBinariaRecursiva(n / 2) + (n % 2);
    }


    public static void main(String[] args) {
        int[] vetor = {7, 3, 5, 2};

        int a = 5;
        System.out.println("Exercicio 01 - Iterativo: " + somaIterativa(a));
        System.out.println("Exercicio 01 - Recursivo: " + somaRecursiva(a));

        System.out.println("Exercicio 02 - Iterativo: " + somaVetorIterativa(vetor));
        System.out.println("Exercicio 02 - Recursivo: " + somaVetorRecursiva(vetor, 0));

        System.out.println("Exercicio 03 - Iterativo: " + somaParesIterativa(vetor));
        System.out.println("Exercicio 03 - Recursivo: " + somaParesRecursiva(vetor, 0));

        System.out.println("Exercicio 04 - Iterativo: " + quantImparesIterativa(vetor));
        System.out.println("Exercicio 04 - Recursivo: " + quantImparesRecursiva(vetor, 0));

        int b = 3;
        System.out.println("Exercicio 05 - Iterativo: " + quantOcorrenciasIterativa(vetor, b));
        System.out.println("Exercicio 05 - Recursivo: " + quantOcorrenciasRecursiva(vetor, b, 0));

        int c = 90;
        int d = 54;
        System.out.println("Exercicio 06 - Iterativo: " + mdcIterativo(c, d));
        System.out.println("Exercicio 06 - Recursivo: " + mdcRecursivo(c, d));

        System.out.println("Exercicio 07 - Iterativo: " + maiorElementoIterativo(vetor));
        System.out.println("Exercicio 07 - Recursivo: " + maiorElementoRecursivo(vetor, 0, vetor[0]));

        int e = 3417;
        System.out.println("Exercicio 08 - Iterativo: " + somaDigitosIterativa(e));
        System.out.println("Exercicio 08 - Recursivo: " + somaDigitosRecursiva(e));

        int f = 12;
        System.out.println("Exercicio 09 - Iterativo: " + representacaoBinariaIterativa(f));
        System.out.println("Exercicio 09 - Recursivo: " + representacaoBinariaRecursiva(f));
    }
}