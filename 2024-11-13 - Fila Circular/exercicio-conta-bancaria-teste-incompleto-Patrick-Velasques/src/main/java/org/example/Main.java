package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilhaObj<Operacao> pilhaOperacoes = new PilhaObj<>(10);
        FilaObj<Operacao> filaOperacoes = new FilaObj<>(10);

        int contadorOperacoes = 0;

        ContaBancaria conta1 = new ContaBancaria(1, 1000.0);
        ContaBancaria conta2 = new ContaBancaria(2, 2000.0);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1- Debitar valor");
            System.out.println("2- Creditar valor");
            System.out.println("3- Desfazer operação");
            System.out.println("4- Agendar operação");
            System.out.println("5- Executar operações agendadas");
            System.out.println("6- Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Debitar valor
                    System.out.println("Digite o número da conta (1 ou 2):");
                    int numContaDebito = scanner.nextInt();
                    System.out.println("Digite o valor a debitar:");
                    double valorDebito = scanner.nextDouble();
                    ContaBancaria contaDebito = numContaDebito == 1 ? conta1 : conta2;

                    if (contaDebito.debitar(valorDebito)) {
                        try {
                            pilhaOperacoes.push(new Operacao(contaDebito, "debito", valorDebito));
                            contadorOperacoes++;
                        } catch (IllegalStateException e) {
                            System.out.println("Erro ao empilhar: " + e.getMessage());
                        }
                    }
                    break;

                case 2: // Creditar valor
                    System.out.println("Digite o número da conta (1 ou 2):");
                    int numContaCredito = scanner.nextInt();
                    System.out.println("Digite o valor a creditar:");
                    double valorCredito = scanner.nextDouble();
                    ContaBancaria contaCredito = numContaCredito == 1 ? conta1 : conta2;

                    contaCredito.creditar(valorCredito);

                    try {
                        pilhaOperacoes.push(new Operacao(contaCredito, "credito", valorCredito));
                        contadorOperacoes++;
                    } catch (IllegalStateException e) {
                        System.out.println("Erro ao empilhar: " + e.getMessage());
                    }
                    break;

                case 3: // Desfazer operação
                    System.out.println("Digite a quantidade de operações a desfazer:");
                    int qtdOperacoes = scanner.nextInt();

                    if (qtdOperacoes > contadorOperacoes) {
                        System.out.println("Quantidade inválida.");
                    } else {
                        for (int i = 0; i < qtdOperacoes; i++) {
                            Operacao opDesfeita = pilhaOperacoes.pop();
                            if (opDesfeita.getTipoOperacao().equals("debito")) {
                                opDesfeita.getContaBancaria().creditar(opDesfeita.getValor());
                            } else {
                                opDesfeita.getContaBancaria().debitar(opDesfeita.getValor());
                            }
                            contadorOperacoes--;
                        }
                    }
                    break;

                case 4: // Agendar operação
                    System.out.println("Digite o tipo de operação (debito ou credito):");
                    String tipoOperacao = scanner.next();
                    System.out.println("Digite o número da conta (1 ou 2):");
                    int numContaAgenda = scanner.nextInt();
                    System.out.println("Digite o valor:");
                    double valorAgenda = scanner.nextDouble();
                    ContaBancaria contaAgenda = numContaAgenda == 1 ? conta1 : conta2;

                    try {
                        filaOperacoes.insert(new Operacao(contaAgenda, tipoOperacao, valorAgenda));
                    } catch (IllegalStateException e) {
                        System.out.println("Erro ao enfileirar: " + e.getMessage());
                    }
                    break;

                case 5: // Executar operações agendadas
                    if (filaOperacoes.isEmpty()) {
                        System.out.println("Não há operações agendadas.");
                    } else {
                        while (!filaOperacoes.isEmpty()) {
                            Operacao opAgendada = filaOperacoes.poll();
                            if (opAgendada.getTipoOperacao().equals("debito")) {
                                opAgendada.getContaBancaria().debitar(opAgendada.getValor());
                            } else {
                                opAgendada.getContaBancaria().creditar(opAgendada.getValor());
                            }
                        }
                    }
                    break;

                case 6: // Sair
                    System.out.println("Encerrando o programa.");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}