    package sptech.school;

    public class PilhaObj<T> {
        private T[] pilha;
        private int topo;

        public PilhaObj(int capacidade) {
            this.pilha = (T[]) new Object[capacidade];
            this.topo = -1;
        }

        public boolean isEmpty() {
            return topo == -1;
        }

        public boolean isFull() {
            return topo == pilha.length - 1;
        }

        public void push(T elemento) {
            if(isFull()){
                throw new IllegalStateException("Pilha Cheia");
            }
            pilha[++topo] = elemento;
        }

        public T peek() {
            return isEmpty() ? null : pilha[topo];
        }

        public T pop() {
            return isEmpty() ? null : pilha[topo--];
        }


        public void exibir() {
            StringBuilder retorno = new StringBuilder("{ ");
            for (int i = topo; i >= 0; i--) {
                retorno.append(pilha[i]).append(" ");
            }
            retorno.append("}");
            System.out.println(retorno);
        }
    }
