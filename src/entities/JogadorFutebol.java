package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class JogadorFutebol {

    private String nome;
    private String posicao;
    private LocalDate dataDeNascimento;
    private String nacionalidade;
    private double altura;
    private double peso;

    public JogadorFutebol() {

    }

    public JogadorFutebol(String nome, String posicao, LocalDate dataDeNascimento, String nacionalidade, double altura, double peso) {
        this.nome = nome;
        this.posicao = posicao;
        this.dataDeNascimento = dataDeNascimento;
        this.nacionalidade = nacionalidade;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int calcularIdade(){
        return LocalDate.now().getYear() - dataDeNascimento.getYear();
    }
    public void aposentar(){
        if (Objects.equals(posicao, "defesa")){
            System.out.println(40 - calcularIdade());
        } else if (Objects.equals(posicao, "meio-campo")) {
            System.out.println(38 - calcularIdade());
        }else if (Objects.equals(posicao, "atacante")){
            System.out.println(35 - calcularIdade());
        }
    }



    public void imprimirTodos() {
        System.out.printf("Nome -> %s\nPosicao -> %s\nData de nascimento -> %s\nNacionalidade -> %s\n" +
                "Altura -> %.2f\nPeso -> %.2f\n\n", nome, posicao, dataDeNascimento, nacionalidade, altura, peso);
    }

}


