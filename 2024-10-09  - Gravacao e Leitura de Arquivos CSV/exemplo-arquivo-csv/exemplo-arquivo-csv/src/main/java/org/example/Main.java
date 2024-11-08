package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    /* Metodo gravaArquivoCsv - Recebe um List de Cachorro e o nome do arquivo a ser
       gravado, sem a extensao .csv.  A extensao eh acrescentada dentro do metodo.
       Este metodo percorre a lista de cachorros e grava os dados de cada cachorro
       em um registro no arquivo .csv
     */
    public static void gravaArquivoCsv(List<Cachorro> lista, String nomeArq) {
        FileWriter arq = null;    // arq representa o arquivo a ser gravado
        Formatter saida = null;   // saida eh o objeto usado para gravar no arquivo
        Boolean deuRuim = false;

        // Acrescenta a extensao .csv ao nome do arquivo
        nomeArq += ".csv";

        // Bloco try-catch para criar ou abrir o arquivo
        try {
            arq = new FileWriter(nomeArq);  // instancia o objeto arq, passando o nomeArq
                                            // nesse momento o arquivo eh aberto

                                            // setar ", true" para (re)gravar dados

            saida = new Formatter(arq);     // instancia o objeto saida, associando ao arq
                                            // esse objeto eh usado para escrever no arquivo
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
            System.exit(1);
        }

        // Bloco try-catch para gravar o arquivo
        try {
            // Percorre a listaDog, fazendo com que dog seja cada cachorro da lista
            for (Cachorro dog : lista) {
                // Grava no arquivo os dados de cada dog da lista
                // separando cada valor com um ; e finalizando com um \n
                // IMPORTANTISSIMO: NAO ACRESCENTAR ESPACOS ENTRE OS FORMATOS
                // NEM TAMANHO DE COLUNA TIPO %7d ou %5.2f SENAO DA RUIM NA HORA DE LER
                // TAMBEM NAO ACRESCENTAR UM ; ANTES DO \n
                // Se o valor for inteiro, use %d (NAO USE POR EXEMPLO %10d)
                // Se o valor for String, use %s
                // Se o valor for Double, use %f ou %.1f ou %.2f
                // Se for Boolean, use %b
                saida.format("%d;%s;%s;%.2f\n", dog.getId(), dog.getNome(),
                        dog.getPorte(), dog.getPeso());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
            deuRuim = true;   // sinaliza que deu erro, pq ainda precisa fechar o arquivo
        }
        finally {   // nesse bloco eh feito o fechamento do arquivo e isso deve
                    // ser feito independente de ter dado erro na gravacoo ou nao
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {    // se deuRuim, termina o programa
                System.exit(1);
            }
        }
    }

     /* Metodo leExibeArquivoCsv - Recebe o nome do arquivo a ser lido, sem a
       extensao .csv.  A extensao eh acrescentada dentro do metodo.
       Este metodo le cada registro do arquivo e exibe na tela o conteudo
       usando saida formatada
     */
    public static void leExibeArquivoCsv(String nomeArq) {
        FileReader arq = null;     // arq representa o arquivo a ser lido
        Scanner entrada = null;    // objeto usado para ler do arquivo
        Boolean deuRuim = false;

        // Acrescenta a extensao .csv ao nome do arquivo
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            // abre o arquivo para leitura
            arq = new FileReader(nomeArq);
            // instancia o objeto Scanner para ler do arquivo
            // delimitador padrão do Scanner é o caractere de espaco
            // aqui, vamos informar que é para usar como delimitador o ; ou o \n
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
            System.exit(1);
        }

        // Bloco try-catch para ler o arquivo
        try {
            // Exibe na console os titulos das colunas
            // Aqui os formatos sao todos %s pois sao os titulos das colunas (Strings)
            // os numeros usados apos o % sao o tamanho de cada coluna
            // nesse tamanho tem que caber o titulo da coluna e tb os valores da coluna
            // quando se coloca %- eh para alinhar para a esquerda (qdo eh texto)
            System.out.printf("%4S %-15S %-9S %4S\n", "id", "nome", "porte", "peso");
            while (entrada.hasNext()) {
                // Le os dados de um registro do arquivo, tomando o cuidado de usar nextInt para
                // valor inteiro, nextDouble para valor double, e next para String
                int id = entrada.nextInt();
                String nome = entrada.next();   // nao use aqui nextLine() senao vai ler ate o final do registro
                String porte = entrada.next();
                Double peso = entrada.nextDouble();

                // exibe os valores dos atributos na console
                // o espacamento das colunas deve ser igual ao do printf antes do while
                // mas aqui usamos %d para valor inteiro e %f para valor double
                System.out.printf("%4d %-15s %-9s %4.1f\n", id, nome, porte, peso);
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            erro.printStackTrace();
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            erro.printStackTrace();
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }


    public static void main(String[] args) {
        List<Cachorro> listaDog = new ArrayList<>();

        listaDog.add(new Cachorro(1, "Mel","Medio",10.0));
        listaDog.add(new Cachorro(2, "Morena","Medio",10.5));
        listaDog.add(new Cachorro(3, "Thor","Grande",50.0));
        listaDog.add(new Cachorro(4, "Rex Ona","Medio",8.0));
        listaDog.add(new Cachorro(5, "Kyra","Medio",10.0));
        listaDog.add(new Cachorro(6, "Amora","Pequeno",7.0));
        listaDog.add(new Cachorro(7, "Lampiao","Pequeno",2.0));

        // Exibe a lista
        System.out.println("Lista de dogs:");
        for (Cachorro dog : listaDog) {
            System.out.println(dog);
        }

        // Grava o conteudo da lista em um arquivo .csv
        gravaArquivoCsv(listaDog, "dogs");

        // Le e exibe o arquivo .csv
        System.out.println("\nDados lidos do arquivo:");
        leExibeArquivoCsv("dogs");

    }
}