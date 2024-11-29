package org.example;
public class Banco {

    // Atributos
    PilhaObj<Operacao> pilhaOperacao = new PilhaObj(10);
    FilaObj<Operacao> filaOperacao = new FilaObj(10);

    // Contador de operações empilhadas
    Integer contadorOperacao = 0;

    // Métodos

    /* Método debitar - recebe o valor a ser debitado e o objeto conta bancária
       Se o débito ocorreu com sucesso, cria um objeto Operacao com os valores adequados
       e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
     */
    public void debitar(double valor, ContaBancaria conta) {
        if (valor > conta.getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        conta.setSaldo(conta.getSaldo() - valor);
        pilhaOperacao.push(new Operacao(conta, "Débito", valor));
        contadorOperacao++;
    }

    /* Método creditar - recebe o valor a ser depositado e o objeto conta bancária
       Executa o depósito, cria um objeto Operacao com os valores adequados
       e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
     */
    public void creditar(double valor, ContaBancaria conta) {
        conta.setSaldo(conta.getSaldo() + valor);
        pilhaOperacao.push(new Operacao(conta, "Crédito", valor));
        contadorOperacao++;
    }

    /* Método desfazerOperacao - recebe a quantidade de operações a serem desfeitas
       Se essa quantidade for inválida, lança IllegalArgumentException
       Senão, "desfaz" a quantidade de operações passadas como argumento
       e atualiza o contadorOperacao
     */
    public void desfazerOperacao(int quantidade) {
        if (quantidade <= 0 || quantidade > pilhaOperacao.getTopo()) {
            throw new IllegalArgumentException("Quantidade de operações inválida");
        }

        for (int i = 0; i < quantidade; i++) {
            Operacao operacao = pilhaOperacao.pop();
            ContaBancaria conta = operacao.getContaBancaria();
            if (operacao.getTipoOperacao().equals("Débito")) {
                conta.setSaldo(conta.getSaldo() + operacao.getValor());
            } else if (operacao.getTipoOperacao().equals("Crédito")) {
                conta.setSaldo(conta.getSaldo() - operacao.getValor());
            }
            contadorOperacao--;
        }
    }


    /* Método agendarOperacao - recebe o tipo da operaçõa, o valor e o objeto conta bancária
       Se um dos argumentos for inválido, lança IllegalArgumentException.
       Senão, cria um objeto Operacao e insere esse objeto na fila.
    */
    public void agendarOperacao(String tipoOperacao, Double valor, ContaBancaria conta) {
        if (tipoOperacao == null || (!tipoOperacao.equals("Débito") && !tipoOperacao.equals("Crédito")) || valor == null || valor <= 0 || conta == null ) {
            throw new IllegalArgumentException("Argumentos inválidos para agendar operação.");
        }

        try {
            Operacao operacao = new Operacao(conta, tipoOperacao, valor);
            filaOperacao.insert(operacao);
            System.out.println("Operação agendada com sucesso.");
        } catch (IllegalStateException e) {
            System.out.println("Erro ao agendar a operação: " + e.getMessage());
        }
    }

    /* Método executarOperacoesAgendadas
       Se não houver operações na fila, exibe mensagem de que não há operações agendadas.
       Senão, esvazia a fila, executando cada uma das operações agendadas.
    */
    public void executarOperacoesAgendadas() {
        if (filaOperacao.isEmpty()) {
            System.out.println("Não há operações agendadas.");
            return;
        }

        while (!filaOperacao.isEmpty()) {
            Operacao operacao = filaOperacao.poll();
            if (operacao.getTipoOperacao().equals("debito")) {
                operacao.getContaBancaria().debitar(operacao.getValor());
                System.out.println("Operação de débito agendada executada.");
            } else if (operacao.getTipoOperacao().equals("credito")) {
                operacao.getContaBancaria().creditar(operacao.getValor());
                System.out.println("Operação de crédito agendada executada.");
            }
        }
    }

    // Getters
    public PilhaObj<Operacao> getPilhaOperacao() {
        return pilhaOperacao;
    }

    public FilaObj<Operacao> getFilaOperacao() {
        return filaOperacao;
    }

    public Integer getContadorOperacao() {
        return contadorOperacao;
    }
}
