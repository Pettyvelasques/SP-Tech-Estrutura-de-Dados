package sptech.school;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void gravaArquivoCsv(List<Atleta> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
            System.exit(1);
        }

        try {
            for (Atleta atleta : lista) {
                saida.format("%d;%s;%d;%.2f;%.2f;%s;%b\n", atleta.getId(), atleta.getNome(), atleta.getIdade(), atleta.getPeso(), atleta.getAltura(), atleta.getEsporte(), atleta.isAtivo());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
            deuRuim = true;
        } finally {
            if (saida != null) {
                saida.close();
            }
            if (arq != null) {
                try {
                    arq.close();
                } catch (IOException erro) {
                    System.out.println("Erro ao fechar o arquivo");
                    deuRuim = true;
                }
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static List<Atleta> leExibeArquivoCsv(String nomeArq) {
        List<Atleta> atletasArquivados = new ArrayList<>();
        FileReader arq = null;
        Scanner entrada = null;
        boolean arquivoExiste = false;

        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
            arquivoExiste = true;
        } catch (FileNotFoundException erro) {
            System.out.println("Erro ao abrir o arquivo: " + nomeArq);
        }

        if (arquivoExiste) {
            try {
                System.out.println("\nDados lidos do arquivo:");
                System.out.printf("%-5s %-10s %-5s %-7s %-7s %-10s %-5s\n", "ID", "Nome", "Idade", "Peso", "Altura", "Esporte", "Ativo");

                while (entrada.hasNext()) {
                    int id = entrada.nextInt();
                    String nome = entrada.next();
                    int idade = entrada.nextInt();
                    double peso = entrada.nextDouble();
                    double altura = entrada.nextDouble();
                    String esporte = entrada.next();
                    boolean ativo = entrada.nextBoolean();

                    Atleta atleta = new Atleta(id, nome, idade, peso, altura, esporte, ativo);
                    atletasArquivados.add(atleta);
                    System.out.printf("%-5d %-10s %-5d %-7.2f %-7.2f %-10s %-5b\n", id, nome, idade, peso, altura, esporte, ativo);
                }
            } catch (NoSuchElementException erro) {
                System.out.println("Erro ao ler os dados: formato inválido no arquivo.");
            } catch (IllegalStateException erro) {
                System.out.println("Erro na leitura do arquivo.");
            } finally {
                if (entrada != null) entrada.close();
                try {
                    if (arq != null) arq.close();
                } catch (IOException erro) {
                    System.out.println("Erro ao fechar o arquivo.");
                }
            }
        }
        return atletasArquivados;
    }



    public static void main(String[] args) {
        ListaObj<Atleta> lista = new ListaObj<>(5);
        Scanner scanner = new Scanner(System.in);
        int opcao;
        List<Atleta> atletasArquivados = leExibeArquivoCsv("lista-de-atletas");

        for (Atleta atleta : atletasArquivados) {
            Atleta atletaCriado = new Atleta(atleta.getId(), atleta.getNome(), atleta.getIdade(), atleta.getPeso(), atleta.getAltura(), atleta.getEsporte(), atleta.isAtivo());
            lista.adiciona(atletaCriado);
        }

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
                    scanner.nextLine();
                    System.out.print("Informe o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe a idade: ");
                    int idade = scanner.nextInt();
                    System.out.print("Informe o peso: ");
                    double peso = scanner.nextDouble();
                    System.out.print("Informe a altura: ");
                    double altura = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Informe o esporte: ");
                    String esporte = scanner.nextLine();
                    System.out.print("Ativo (true/false): ");
                    boolean ativo = scanner.nextBoolean();

                    Atleta atleta = new Atleta(id, nome, idade, peso, altura, esporte, ativo);
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
                    System.out.println("Preparando para encerrar o programa...");
                    List<Atleta> atletas = new ArrayList<>();

                    for(int i=0; i< lista.getTamanho(); i++) {
                        atletas.add(lista.getElemento(i));
                    }
                    gravaArquivoCsv(atletas, "lista-de-atletas");
                    System.out.println("Arquivo com a lista de atletas gerado com sucesso!");
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 3);
    }
}
