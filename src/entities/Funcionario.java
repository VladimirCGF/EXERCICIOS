package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Funcionario {

    private String nome;
    private String sobrenome;
    private BigDecimal salarioMensal;
    private LocalDate dataEntrada;
    private List<Funcionario> funcionarioList = new ArrayList<>();

    public Funcionario() {

    }

    public Funcionario(List<Funcionario> list) {
        this.funcionarioList = list;
    }

    public Funcionario(String nome, String sobrenome, BigDecimal salarioMensal, LocalDate dataEntrada) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        setSalarioMensal(salarioMensal);
        this.dataEntrada = dataEntrada;
    }

//    public static void play() {
//        Scanner sc = new Scanner(System.in);
//        Funcionario funcionario = new Funcionario();
//
//
//        System.out.println("Deseja armazenar funcionario ? Se sim pressione 'S'");
//        char opcao = sc.next().toLowerCase().charAt(0);
//        if (opcao == 's') {
//            while (opcao == 's') {
//                funcionario.armazenarFuncionario();
//                System.out.println("Deseja armazenar mais um funcionario ? Se sim pressione 'S'");
//                opcao = sc.next().toLowerCase().charAt(0);
//            }
//        }
//
//        funcionario.imprimirFuncionarios();
//        funcionario.aumentoSalario();
//        funcionario.salarioAnual();
//
//        System.out.println("NUMEROS DE FUNCIONARIO ATÉ DATA ATUAL: " + funcionario.numeroFuncionarioAno());
//
//
//        sc.close();
//    }

    public void armazenarFuncionario() {
        Scanner sc = new Scanner(System.in);

        System.out.print("NOME: ");
        String nome = sc.next();
        System.out.print("SOBRENOME: ");
        String sobrenome = sc.next();
        System.out.print("SALARIO MENSAL: ");
        BigDecimal salarioMensal = sc.nextBigDecimal();
        System.out.println("DATA DE ENTRADA");
        System.out.print("ANO: ");
        int ano = sc.nextInt();
        System.out.print("MÊS: ");
        int mes = sc.nextInt();
        System.out.print("DIA: ");
        int dia = sc.nextInt();
        LocalDate dataEntrada = LocalDate.of(ano, mes, dia);

        this.funcionarioList.add(new Funcionario(nome, sobrenome, salarioMensal, dataEntrada));
    }

    public void removerFuncionario(String nome) {
        funcionarioList.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public long numeroFuncionarioAno() {
        return funcionarioList.stream()
                .filter(funcionario -> funcionario.getDataEntrada().isBefore(LocalDate.now())
                        || funcionario.getDataEntrada().isEqual(LocalDate.now())).count();
    }


    public void imprimirFuncionarios() {
        funcionarioList.forEach(System.out::println);
    }

    public Funcionario buscarFuncionario(String nome) {
        return funcionarioList.stream().filter(funcionarioList -> funcionarioList.getNome().equals(nome)).findFirst().orElse(null);
    }

    public void aumentoSalario() {
        funcionarioList.forEach(funcionario -> funcionario.setSalarioMensal(funcionario.getSalarioMensal().multiply(new BigDecimal("1.1"))));
    }

    public void salarioAnual() {
        funcionarioList.forEach(funcionario -> System.out.println("\nNOME: " + funcionario.getNome() + "\nSALARIO ANUAL: "
                + funcionario.getSalarioMensal().multiply(new BigDecimal("12"))));
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public BigDecimal getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(BigDecimal salarioMensal) {
        if (salarioMensal.compareTo(BigDecimal.ZERO) < 0) {
            salarioMensal = BigDecimal.valueOf(0);
        }
        this.salarioMensal = salarioMensal;
    }

    @Override
    public String toString() {
        return "\nFuncionario " +
                "\nNome: " + nome +
                "\nSobrenome: " + sobrenome +
                "\nSalarioMensal: R$ " + salarioMensal +
                "\nDataEntrada: " + dataEntrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }
}
