package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Carros {

    private String nome;
    private Double tanque;
    private Double gasolina;
    private Double distancia;

    private List<Carros> carrosList = new ArrayList<>();

    public Carros() {

    }

    public Carros(List<Carros> carrosList) {
        this.carrosList = carrosList;
    }

    public Carros(String nome) {
        this.nome = nome;
    }

    public static void play() {
        Scanner sc = new Scanner(System.in);
        Carros carros = new Carros();

        carros.armazenarCarros("CELTA");
        carros.armazenarCarros("GOL");
        System.out.println("QUAL CARRO DESEJA ABASTECER");
        String nomeAbastecer = sc.next();
        System.out.println("QUANTOS LITROS DE GASOLINA");
        Double quantiaAbastecer = sc.nextDouble();
        carros.abastecer(nomeAbastecer, quantiaAbastecer);
        carros.imprimirCarros();
        carros.percorre("CELTA", 200.00);


    }

    public void armazenarCarros(String nome) {
        Scanner sc = new Scanner(System.in);
        carrosList.add(new Carros(nome));
    }

    public void imprimirCarros() {
        carrosList.forEach(System.out::println);
    }

    public Carros buscarCarro(String nome) {
        return carrosList.stream().filter(carros -> carros.getNome().equals(nome)).findFirst().orElse(null);
    }
    public void abastecer(String nome, Double gasolina) {
        Carros carros = buscarCarro(nome);
        if (carros != null) {
            carros.setGasolina(gasolina);
            carros.setTanque(gasolina);
        }
    }
    public void percorre(String nome, Double distancia) {
        Carros carro = buscarCarro(nome);
        double combustivel = (carro.getConsumo() * carro.getTanque() - distancia) / carro.getConsumo();
        if (distancia > (carro.getConsumo() * carro.getTanque())) {
            System.out.println("DISTANCIA PERCORRIDA: " + (carro.getConsumo() * carro.getTanque()) + " FALTOU: " + (distancia - (carro.getConsumo() * carro.getTanque())));
        } else {
            System.out.printf("QUANTIDADE RESTANTE NO TAQUE: %.2f DISTANCIA PERCORRIDA: %.2f\n", combustivel, distancia);
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getTanque() {
        return tanque;
    }

    public void setTanque(Double gasolina) {
        if (gasolina > 50.00) {
            this.tanque = 50.00;
        } else {
            this.tanque = gasolina;
        }
    }

    public Double getGasolina() {
        return gasolina;
    }

    public void setGasolina(Double gasolina) {
        if (gasolina > 50.00) {
            this.gasolina = 50.00;
        } else {
            this.gasolina = gasolina;
        }
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getConsumo() {
        return 15.00;
    }

    public List<Carros> getCarrosList() {
        return carrosList;
    }

    public void setCarrosList(List<Carros> carrosList) {
        this.carrosList = carrosList;
    }

    @Override
    public String toString() {
        return "\nNOME: " + nome + "\nTANQUE: " + tanque + "\nGASOLINA: " + gasolina + "\nDISTANCIA: " + distancia;

    }
}
