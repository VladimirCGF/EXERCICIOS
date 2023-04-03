package entities;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Agenda {
    private List<Pessoa> list = new ArrayList<>();

    public Agenda() {

    }

    public Agenda(List<Pessoa> list) {
        this.list = list;
    }

    public static void play() {
        Scanner sc = new Scanner(System.in);
        Agenda agenta = new Agenda();

        System.out.println("Deseja armazenar uma pessoa ? Se sim pressione 'S'");
        char opcao = sc.next().toLowerCase().charAt(0);
        if (opcao == 's') {
            while (opcao == 's') {
                agenta.armazenarPessoa();
                System.out.println("Deseja armazenar mais uma pessoa ? Se sim pressione 'S'");
                opcao = sc.next().toLowerCase().charAt(0);
            }
        }

        System.out.println("O QUE DESEJA FAZER ?");
        System.out.println("1 -> IMPRIMIR AGENTA\n2 -> REMOVER UMA PESSOA\n3 -> IMPRIMIR POSIÇÃO DA PESSOA");
        int servicos = sc.nextInt();
        switch (servicos) {
            case 1 -> agenta.imprimirAgenta();
            case 2 -> {
                System.out.println("QUEM DESEJA REMOVER DA LISTA ?");
                agenta.removerPessoa(sc.next());
            }
            case 3 -> {
                System.out.println("DIGITE NOME DA PESSOA QUE DESEJA A POSIÇÃO");
                String imprimirNome = sc.next();
                agenta.imprimirPessoa(imprimirNome);
                System.out.println("Posição = " + agenta.imprimirPosicao(imprimirNome));
            }
            default -> System.out.println("NUMERO INVALIDO");
        }

        sc.close();
    }

    public void armazenarPessoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        System.out.print("Altura: ");
        float altura = sc.nextFloat();
        list.add(new Pessoa(nome, idade, altura));
    }

    public Pessoa buscarPessoa(String nome) {
        return list.stream().filter(pessoa -> pessoa.getNome().equals(nome)).findFirst().orElse(null);
    }

    public int imprimirPosicao(String nome) {
        return list.indexOf(buscarPessoa(nome));
    }

    public void removerPessoa(String nome) {
        list.removeIf(pessoa -> pessoa.getNome().equals(nome));
    }

    public void imprimirPessoa(String nome) {
        list.stream().filter(pessoa -> pessoa.getNome().equals(nome)).forEach(System.out::println);
    }

    public void imprimirAgenta() {
        list.forEach(System.out::println);
    }

    public List<Pessoa> getList() {
        return list;
    }

    public void setList(List<Pessoa> list) {
        this.list = list;
    }

}
