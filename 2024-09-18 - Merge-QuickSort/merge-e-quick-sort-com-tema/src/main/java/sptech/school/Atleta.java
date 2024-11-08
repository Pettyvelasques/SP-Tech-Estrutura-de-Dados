package sptech.school;

public class Atleta {
    private int id;
    private String nome;
    private String sobrenome;
    private double peso;
    private int numMedalhas;

    public Atleta(int id, String nome, String sobrenome, double peso, int numMedalhas) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.peso = peso;
        this.numMedalhas = numMedalhas;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", peso=" + peso +
                ", numMedalhas=" + numMedalhas +
                '}';
    }
}
