package sptech.school;

public class Atleta {
    private int id;
    private int idade;
    private String nome;
    private double peso;
    private double altura;
    private String esporte;
    private boolean ativo;

    public Atleta(int id, int idade, String nome, double peso, double altura, String esporte, boolean ativo) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.esporte = esporte;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getEsporte() {
        return esporte;
    }

    public void setEsporte(String esporte) {
        this.esporte = esporte;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-10s %-5d %-7.2f %-7.2f %-10s %-5s", id, nome, idade, peso, altura, esporte, ativo ? "Sim" : "Não");
    }
}
