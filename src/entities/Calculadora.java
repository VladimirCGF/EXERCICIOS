package entities;

import java.util.Scanner;

public class Calculadora extends CalculadoraCientifica {
    public static void play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("PRESSIONE 'L' PARA LIGAR");
        char opcao = sc.next().toLowerCase().charAt(0);
        double resultado = 0;
        if (opcao == 'l') {
            Double a = sc.nextDouble();
            String sinal = sc.next().toLowerCase();
            switch (sinal) {
                case "+" -> resultado = somar(a, sc.nextDouble());
                case "-" -> resultado = subtrair(a, sc.nextDouble());
                case "/" -> resultado = dividir(a, sc.nextDouble());
                case "*" -> resultado = multiplicar(a, sc.nextDouble());
                case "raiz" -> resultado = raizQuadrada(a);
                case "potencia" -> resultado = potencia(a, sc.nextDouble());
                default -> System.out.println("SINAL INVALIDO");
            }
            System.out.println(resultado);
        }
        sc.close();
    }

    public static double somar(Double a, Double b) {
        return a + b;
    }

    public static double subtrair(Double a, Double b) {
        return a - b;
    }

    public static double dividir(Double a, Double b) {
        return a / b;
    }

    public static double multiplicar(Double a, Double b) {
        return a * b;
    }

}
