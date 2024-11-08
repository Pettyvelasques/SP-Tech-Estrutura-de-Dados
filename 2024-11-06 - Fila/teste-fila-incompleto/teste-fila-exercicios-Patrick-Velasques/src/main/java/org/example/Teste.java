package org.example;

public class Teste {
    public static void main(String[] args) {
        int[] vetor =  {2,7,-3,-50,45,-4,30,-21,38};
        separaPositivoNegativoEmOrdem(vetor);
        separaPositivoNegativoOrdemDiferente(vetor);
    }

    public static void separaPositivoNegativoEmOrdem(int[] vetor){
        FilaObj<Integer> filaPositivos = new FilaObj<>(vetor.length);
        FilaObj<Integer> filaNegativos = new FilaObj<>(vetor.length);

        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] >= 0){
                filaPositivos.insert(vetor[i]);
            }else{
                filaNegativos.insert(vetor[i]);
            }
        }
        filaPositivos.exibe();
        filaPositivos.limparFila();

        filaNegativos.exibe();
        filaNegativos.limparFila();
    }

    public static void separaPositivoNegativoOrdemDiferente(int[] vetor){
        FilaObj<Integer> filaPositivos = new FilaObj<>(vetor.length);
        FilaObj<Integer> filaNegativosReversa = new FilaObj<>(vetor.length);
        int[] filaNegativos = new int[vetor.length];
        int negativosTamanho = -1;

        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] >= 0){
                filaPositivos.insert(vetor[i]);
            }else{
                filaNegativos[++negativosTamanho] = vetor[i];
            }
        }
        for(int i = negativosTamanho; i >= 0; i--){
            filaNegativosReversa.insert(filaNegativos[i]);
            negativosTamanho--;
        }

        System.out.println(negativosTamanho);
        filaPositivos.exibe();
        filaPositivos.limparFila();

        filaNegativosReversa.exibe();
        filaNegativosReversa.limparFila();
    }
}
