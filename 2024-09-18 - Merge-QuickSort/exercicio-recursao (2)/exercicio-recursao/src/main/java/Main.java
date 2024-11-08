public class Main {
    // EX 1
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

    // EX 2
    public static int somaVetorIterativa(int[] vetor) {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }
        return soma;
    }
    public static int somaVetorRecursiva(int[] vetor, int i) {
        if (i == vetor.length) {
            return 0;
        } else {
            return vetor[i] + somaVetorRecursiva(vetor, i + 1);
        }
    }

    // EX 3
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
        if (i == vetor.length) {
            return 0;
        } else {
            if (vetor[i] % 2 == 0) {
                return vetor[i] + somaParesRecursiva(vetor, i + 1);
            } else {
                return somaParesRecursiva(vetor, i + 1);
            }
        }
    }

    // EX 4
    public static int contaImparesIterativa(int[] vetor) {
        int quantidade = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 != 0) {
                quantidade++;
            }
        }
        return quantidade;
    }
    public static int contaImparesRecursiva(int[] vetor, int i) {
        if (i == vetor.length) {
            return 0;
        } else {
            if (vetor[i] % 2 != 0) {
                return 1 + contaImparesRecursiva(vetor, i + 1);
            } else {
                return contaImparesRecursiva(vetor, i + 1);
            }
        }
    }

    // EX 5
    public static int contaOcorrenciasIterativa(int[] vetor, int x) {
        int ocorrencias = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == x) {
                ocorrencias++;
            }
        }
        return ocorrencias;
    }
    public static int contaOcorrenciasRecursiva(int[] vetor, int i, int x) {
        if (i == vetor.length) {
            return 0;
        } else {
            if (vetor[i] == x) {
                return 1 + contaOcorrenciasRecursiva(vetor, i + 1, x);
            } else {
                return contaOcorrenciasRecursiva(vetor, i + 1, x);
            }
        }
    }

    // EX 6
    public static int mdcIterativo(int a, int b) {
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
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

    // EX 7
    public static int maiorElementoIterativo(int[] vetor) {
        int maior = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        return maior;
    }
    public static int maiorElementoRecursivo(int[] vetor, int i) {
        if (i == vetor.length - 1) {
            return vetor[i];
        } else {
            int maiorResto = maiorElementoRecursivo(vetor, i + 1);
            if (vetor[i] > maiorResto) {    
                return vetor[i];
            } else {
                return maiorResto;
            }
        }
    }

    // EX 8
    public static int somaDigitosIterativa(int n) {
        int soma = 0;
        while (n > 0) {
            soma += n % 10;
            n = n / 10;
        }
        return soma;
    }
    public static int somaDigitosRecursiva(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (n % 10) + somaDigitosRecursiva(n / 10);
        }
    }

    // EX 9
    public static String binarioIterativo(int n) {
        StringBuilder binario = new StringBuilder();
        while (n > 0) {
            binario.insert(0, n % 2);
            n = n / 2;
        }
        return binario.toString();
    }
    public static String binarioRecursivo(int n) {
        if (n == 0) {
            return "";
        } else {
            return binarioRecursivo(n / 2) + (n % 2);
        }
    }


    public static void main(String[] args) {
        System.out.println("MDC iterativo entre 90 e 54: " + mdcIterativo(90, 54));
        System.out.println("MDC recursivo entre 90 e 54: " + mdcRecursivo(90, 54));

        int[] vetor = {7, 3, 5, 2};
        System.out.println("Maior elemento (iterativo): " + maiorElementoIterativo(vetor));
        System.out.println("Maior elemento (recursivo): " + maiorElementoRecursivo(vetor, 0));

        int numero = 132;
        System.out.println("Soma dos dígitos (iterativo): " + somaDigitosIterativa(numero));
        System.out.println("Soma dos dígitos (recursivo): " + somaDigitosRecursiva(numero));

        int numBinario = 12;
        System.out.println("Número em binário (iterativo): " + binarioIterativo(numBinario));
        System.out.println("Número em binário (recursivo): " + binarioRecursivo(numBinario));
    }



}
