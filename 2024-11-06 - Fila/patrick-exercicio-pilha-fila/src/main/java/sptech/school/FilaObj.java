package sptech.school;

public class FilaObj<T> {
    // Atributos
    private int tamanho;
    private T[] fila;

    // Construtor
    public FilaObj(int tamanho, String[] fila) {
        this.tamanho = tamanho;
        this.fila = (T[]) fila;
    }
    public FilaObj(int tamanho) {
        this.fila = (T[]) new Object[tamanho];
        this.tamanho = -1;
    }

    // Métodos

    /* Método isEmpty() - retorna true se a fila está vazia e false caso contrário */
    public boolean isEmpty() {
        return tamanho == -1;
    }

    /* Método isFull() - retorna true se a fila está cheia e false caso contrário */
    public boolean isFull() {
        return tamanho == fila.length - 1;
    }

    /* Método insert - recebe um elemento e insere esse elemento na fila
                       no índice tamanho, e incrementa tamanho
                       Lançar IllegalStateException caso a fila esteja cheia
     */
    public void insert(T info) {
        if(isFull()){
            throw new IllegalStateException("Fila Cheia");
        }
        fila[++tamanho] = info;
    }

    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public String peek() {
        if(isEmpty()){
            return null;
        }
        return (String) fila[0];
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
       Depois que a fila andar, "limpar" o ex-último elemento da fila, atribuindo null
     */
    public String poll() {
        if(isEmpty()){
            return null;
        }
        String s = (String) fila[0];
        for(int i = 1; i < tamanho; i++ ){
            fila[i-1] = fila[i];
        }
        fila[tamanho--] = null;
        return s;
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public void exibe() {
        StringBuilder retorno = new StringBuilder("{ ");
        for (int i = 0; i <= tamanho; i++) {
            retorno.append(fila[i]).append(" ");
        }
        retorno.append("}");
        System.out.println(retorno);
    }

    public String exibeEscrito() {
        StringBuilder retorno = new StringBuilder("{ ");
        for (int i = 0; i <= tamanho; i++) {
            retorno.append(fila[i]).append(" ");
        }
        retorno.append("}");
        return retorno.toString();
    }

    public void limparFila(){
        for(int i = 0; i < tamanho; i++){
            fila[i] = null;
        }
        tamanho = -1;
    }

    /* Usado nos testes  - complete para que fique certo */
    public int getTamanho(){
        return tamanho + 1;
    }
}

