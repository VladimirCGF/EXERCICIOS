package application;

import entities.*;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Funcionario funcionario = new Funcionario();


        System.out.println("Deseja armazenar funcionario ? Se sim pressione 'S'");
        char opcao = sc.next().toLowerCase().charAt(0);
        if (opcao == 's') {
            while (opcao == 's') {
                funcionario.armazenarFuncionario();
                System.out.println("Deseja armazenar mais um funcionario ? Se sim pressione 'S'");
                opcao = sc.next().toLowerCase().charAt(0);
            }
        }

        funcionario.imprimirFuncionarios();
        funcionario.aumentoSalario();
        funcionario.salarioAnual();

        System.out.println("NUMEROS DE FUNCIONARIO ATÉ DATA ATUAL: " + funcionario.numeroFuncionarioAno());


        sc.close();
    }
}