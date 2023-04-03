package entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fatura {
    private String nome;
    private String descricao;
    private int quantidade;
    private BigDecimal preco;

    private List<Fatura> faturaList = new ArrayList<>();

    public Fatura() {
    }

    public Fatura(List<Fatura> faturaList) {
        this.faturaList = faturaList;
    }

    public Fatura(String nome, String descricao, int quantidade, BigDecimal preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        setPreco(preco);
    }

    public static void play() {
        Scanner sc = new Scanner(System.in);
        Fatura fatura = new Fatura();

        System.out.println("Deseja armazenar um produto ? Se sim pressione 'S'");
        char opcao = sc.next().toLowerCase().charAt(0);
        if (opcao == 's') {
            while (opcao == 's') {
                fatura.armazenarProduto();
                System.out.println("Deseja armazenar mais um produto ? Se sim pressione 'S'");
                opcao = sc.next().toLowerCase().charAt(0);
            }
        }
        fatura.imprimirEstoque();

        System.out.println("\nFATURA TOTAL: " + fatura.getTotal());


        sc.close();
    }

    public void armazenarProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("NOME DO PRODUTO: ");
        String nome = sc.next().toLowerCase();
        System.out.print("DESCRICAO: ");
        String descricao = sc.next().toLowerCase();
        System.out.print("QUANTIDADE: ");
        int quantidade = sc.nextInt();
        System.out.print("PREÇO ");
        preco = sc.nextBigDecimal();
        faturaList.add(new Fatura(nome, descricao, quantidade, preco));
    }

    public Fatura buscarProduto(String nome) {
        return faturaList.stream().filter(p -> getNome().equals(nome)).findFirst().orElse(null);
    }

    public void imprimirProduto(String nome) {
        faturaList.stream().filter(faturaList -> faturaList.getNome().equals(nome)).forEach(System.out::println);
    }

    public int imprimirPosicao(String nome) {
        return faturaList.indexOf(buscarProduto(nome));
    }

    public void removerProduto(String nome) {
        faturaList.removeIf(p -> p.getNome().equals(nome));
    }

    public BigDecimal getTotal() {
        return BigDecimal.valueOf(faturaList.stream()
                .mapToDouble(fatura -> fatura.getPreco().multiply(BigDecimal.valueOf(fatura.getQuantidade())).doubleValue())
                .sum());
    }

    public void imprimirEstoque() {
        faturaList.forEach(System.out::println);
    }

    public List<Fatura> getFaturaList() {
        return faturaList;
    }

    public void setFaturaList(List<Fatura> faturaList) {
        this.faturaList = faturaList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        if (preco.compareTo(BigDecimal.ZERO) < 0) {
            preco = BigDecimal.valueOf(0);
        }
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Fatura" +
                "\nNome: " + nome +
                "\nDescricao: " + descricao +
                "\nQuantidade: " + quantidade +
                "\nPreco Unitário: " + preco +
                "\nPreco Total: " + preco.multiply(BigDecimal.valueOf(quantidade));
    }
}
