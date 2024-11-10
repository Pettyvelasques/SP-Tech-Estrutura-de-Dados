package sptech.school;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repositorio repositorio = new Repositorio();
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1- Salvar objeto");
            System.out.println("2- Deletar objeto");
            System.out.println("3- Exibir");
            System.out.println("4- Desfazer");
            System.out.println("5- Agendar salvar");
            System.out.println("6- Executar agendado");
            System.out.println("7- Fim");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Atleta atleta = lerDadosAtleta(scanner);
                    repositorio.salvar(atleta);
                    break;

                case 2:
                    System.out.print("Digite o ID do objeto a ser deletado: ");
                    int id = scanner.nextInt();
                    repositorio.deletar(id);
                    break;

                case 3:
                    repositorio.exibir();
                    break;

                case 4:
                    repositorio.desfazer();
                    break;

                case 5:
                    Atleta atletaAgendar = lerDadosAtleta(scanner);
                    repositorio.agendarSalvar(atletaAgendar);
                    break;

                case 6:
                    System.out.print("Digite a quantidade de operações agendadas a serem executadas: ");
                    int qtdOperacoes = scanner.nextInt();
                    repositorio.executarAgendado(qtdOperacoes);
                    break;

                case 7:
                    running = false;
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static Atleta lerDadosAtleta(Scanner scanner) {
        System.out.print("Digite o nome do atleta: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do atleta: ");
        int idade = scanner.nextInt();

        System.out.print("Digite o peso do atleta: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite a altura do atleta(usando vírgula): ");
        double altura = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Digite o esporte do atleta: ");
        String esporte = scanner.nextLine();

        System.out.print("O atleta está ativo? (true/false): ");
        boolean ativo = scanner.nextBoolean();

        return new Atleta(0, nome, idade, peso, altura, esporte, ativo);
    }
}