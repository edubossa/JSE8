package br.com.ews.jse8.pojo;

/**
 * Created by wallace on 17/06/16.
 */
public class Pessoa {

    private String nome;
    private Double rg;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, Double rg) {
        this.nome = nome;
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRg() {
        return rg;
    }

    public void setRg(Double rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", rg= " + rg + "]";
    }

}
