package sptech.school;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void contagemRegressiva(int n){
        for (int i = n; i >= 0; i--){
            System.out.println(i);
        }
    }

    public static void contagemRegressivaRecursiva(int n){
        if (n == 0){
            System.out.println(n);
        } else {
            System.out.println(n);
            contagemRegressivaRecursiva(n - 1);
            System.out.println("n = " + n);
        }
    }

    //Fatorial
    //n! = 1, n = 0
    //n! = n * (n-1)!, se n > 0
    //2!= 2 * 1! = 2* 1 * 0! = 2 * 1 = 2
    public static int fatorial(int n){
        if (n == 1){
            return 1;
        } else {
            return n + fatorial(n - 1);
        }
    }

    public static void exibeVetor(int[] v, int i){
        if (i < v.length){
            System.out.println(v[i]);
            exibeVetor(v, i + 1);
        }
    }

    public static void exibeVetorInvertido(int[] v, int i){
        if (i >= 0){
            System.out.println(v[i]);
            exibeVetorInvertido(v, i - 1);
        }
    }

    public static void main(String[] args) {

        int[] vetor = {10, 20, 30, 40, 50, 60};

        System.out.println("Contagem regressiva do 5:");
        contagemRegressiva(5);

        System.out.println("\ncontagem regressiva recursiva do 5:");
        contagemRegressivaRecursiva(5);

        System.out.println("4! = " + fatorial(4));
        System.out.println("4! = " + fatorial(5));

        System.out.println("Exibicao do vetor: ");
        exibeVetor(vetor, 0);

        System.out.println("Exibicao do vetor: ");
        exibeVetorInvertido(vetor, vetor.length -1);
    }
}
