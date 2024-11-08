package sptech.school;

public class ListaEstatica {
        private int[] vetor;
        private int tamanhoVetor;

        public ListaEstatica(int tamanho) {
            vetor = new int[tamanho];
            tamanhoVetor = 0;
        }

        public void adiciona(int elemento) {
            if (tamanhoVetor >= vetor.length) {
                System.out.println("Lista cheia");
            } else {
                vetor[tamanhoVetor] = elemento;
                tamanhoVetor++;
            }
        }

        public void exibe() {
            if (tamanhoVetor == 0) {
                System.out.println("Lista vazia");
            } else {
                for (int i = 0; i < tamanhoVetor; i++) {
                    System.out.print(vetor[i] + " ");
                }
                System.out.println();
            }
        }

        public int busca(int elemento) {
            for (int i = 0; i < tamanhoVetor; i++) {
                if (vetor[i] == elemento) {
                    return i;
                }
            }
            return -1;
        }

        public boolean removePeloIndice(int indice) {
            if (indice < 0 || indice >= tamanhoVetor) {
                return false;
            }
            for (int i = indice; i < tamanhoVetor - 1; i++) {
                vetor[i] = vetor[i + 1];
            }
            tamanhoVetor--;
            return true;
        }

        public boolean removeElemento(int elemento) {
            return removePeloIndice(busca(elemento));
        }

        public void substitui(int elemento1, int elemento2){
            int indice = busca(elemento1);
            if (indice == -1) {
                System.out.println("Valor não encontrado");;
            }else{
                vetor[indice] = elemento2;
            }
        }

        public int contaOcorrencias(int elemento){
            int nroRepeticoes = 0;
            for (int i = 0; i < tamanhoVetor - 1; i++) {
                if(vetor[i] == elemento){
                    nroRepeticoes++;
                }
            }
            return nroRepeticoes;
        }

        public void adicionaNoInicio(int elemento){
            if (tamanhoVetor >= vetor.length) {
                System.out.println("Lista cheia");
            }else {
                for (int i = tamanhoVetor; i > 0; i--) {
                    vetor[i] = vetor[i - 1];
                }
                vetor[0] = elemento;
                tamanhoVetor++;
            }
        }

    public void adicaoOrdenada(int elemento){
        if (tamanhoVetor >= vetor.length) {
            System.out.println("Lista cheia");
        }else if(tamanhoVetor == 0){
            vetor[0] = elemento;
            tamanhoVetor++;
        }else {
            int indice = 0;
            for (int i = tamanhoVetor; i > 0; i--) {
                if(vetor[i-1] > elemento) {
                    vetor[i] = vetor[i-1];
                }
                else{
                    indice = i;
                    break;
                }
            }
            vetor[indice] = elemento;
            tamanhoVetor++;
        }
    }
}
