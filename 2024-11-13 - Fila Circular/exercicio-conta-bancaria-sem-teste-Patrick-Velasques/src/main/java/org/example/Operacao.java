package org.example;
public class Operacao {

    // Atributos
    private ContaBancaria contaBancaria;
    private String tipoOperacao;
    private Double valor;


    // Construtor
    public Operacao(ContaBancaria contaBancaria, String tipoOperacao, Double valor) {
        this.contaBancaria = contaBancaria;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }


    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }


    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }


    public void setValor(Double valor) {
        this.valor = valor;
    }


    // Métodos

    // toString()
    @Override
    public String toString() {
        return String.format("\n----------Operação----------\n" +
                        "Tipo de operação: %s\n" +
                        "Valor da operação: R$%.2f",
                tipoOperacao, valor);
    }


    // Getters
    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public Double getValor() {
        return valor;
    }
}
