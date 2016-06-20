package br.com.ews.jse8.pojo;

/**
 * Created by wallace on 17/06/16.
 */
public class Turma {

    private String turma;
    private int alunos;

    public Turma() {}

    public Turma(String turma, int alunos) {
        this.turma = turma;
        this.alunos = alunos;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public int getAlunos() {
        return alunos;
    }

    public void setAlunos(int alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "turma='" + turma + '\'' +
                ", alunos=" + alunos +
                '}';
    }

}
