package sptech.school;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaObj<Atleta> lista = new ListaObj<>(5);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar Atleta");
            System.out.println("2 - Exibir Atletas");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Informe a idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Informe o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe o peso: ");
                    double peso = scanner.nextDouble();
                    System.out.print("Informe a altura: ");
                    double altura = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Informe o esporte: ");
                    String esporte = scanner.nextLine();
                    System.out.print("Ativo (true/false): ");
                    boolean ativo = scanner.nextBoolean();

                    Atleta atleta = new Atleta(id, idade, nome, peso, altura, esporte, ativo);
                    lista.adiciona(atleta);
                    System.out.println("Atleta adicionado com sucesso!");
                    break;

                case 2:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Nenhum atleta cadastrado.");
                    } else {
                        System.out.printf("%-5s %-10s %-5s %-7s %-7s %-10s %-5s\n", "ID", "Nome", "Idade", "Peso", "Altura", "Esporte", "Ativo");
                        for (int i = 0; i < lista.getTamanho(); i++) {
                            System.out.println(lista.getElemento(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 3);
    }
}
