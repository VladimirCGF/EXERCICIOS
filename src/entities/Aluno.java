package entities;

import java.math.BigDecimal;

public class Aluno {
    private String nome;
    private double nota1;
    private double nota2;
    private double trabalho;

    public Aluno() {
    }

    public Aluno(String nome, double nota1, double nota2, double trabalho) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.trabalho = trabalho;
    }

    public static void play() {
        Aluno aluno = new Aluno("Vladimir", 6, 10, 2);
        System.out.println("Aluno -> " + aluno.getNome());
        System.out.printf("Nota 1 -> %.2f\n", aluno.getNota1());
        System.out.printf("Nota 2 -> %.2f\n", aluno.getNota2());
        System.out.printf("Media -> %.2f\n", aluno.media());
        if (aluno.finalProva() > 0) {
            System.out.printf("Quantos precisa para final -> %.2f\n", aluno.finalProva());
        } else
            System.out.println("ALUNO APROVADO");
    }

    public String getNome() {

        return this.nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public double getNota1() {

        return this.nota1;
    }

    public void setNota1(double nota1) {

        this.nota1 = nota1;
    }

    public double getNota2() {

        return this.nota2;
    }

    public void setNota2(double nota2) {

        this.nota2 = nota2;
    }

    public double getTrabalho() {

        return this.trabalho;
    }

    public void setTrabalho(double trabalho) {

        this.trabalho = trabalho;
    }

    public double media() {
        return (2.5 * this.nota1 + 2.5 * this.nota2 + 2.0 * this.trabalho) / 7;
    }

    public double finalProva() {
        if (media() > 7) {
            return 0.0;
        } else
            return (14 - media());
    }

}


