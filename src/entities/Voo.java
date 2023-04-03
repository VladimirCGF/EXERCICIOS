package entities;

public class Voo {

    private int numeroDoVoo;
    private Data date;
    private boolean[] cadeira;

    public Voo() {
        cadeira = new boolean[100];
    }

    public Voo(int numeroDoVoo, Data date, boolean[] cadeira) {
        this.numeroDoVoo = numeroDoVoo;
        this.date = date;
        this.cadeira = cadeira;
    }

    public int getNumeroDoVoo() {
        return numeroDoVoo;
    }

    public void setNumeroDoVoo(int numeroDoVoo) {
        this.numeroDoVoo = numeroDoVoo;
    }

    public Data getDate() {
        return date;
    }

    public void setDate(Data date) {
        this.date = date;
    }

    public boolean[] getCadeira() {
        return cadeira;
    }

    public void setCadeira(int i, boolean ocupacao) {
        this.cadeira[i] = ocupacao;
    }


    public int proximoLivre() {
        for (int i = 0; i < cadeira.length; i++) {
            if (cadeira[i] == true) {
                return i;
            }
        }
        return 0;
    }

    public void verificar(int amount) {
        if (cadeira[amount] == false) {
            System.out.println("Cadeira ocupada");
        } else {
            System.out.println("Cadeira livre");
        }
    }

    public int vagas() {
        int count = 0;
        for (int i = 0; i < cadeira.length; i++) {
            if (cadeira[i] == true) {
                count++;
            }
        }
        return count;
    }

    public boolean ocupa(int amount) {
        if (cadeira[amount] == true) {
            return true;
        } else {
            return false;
        }
    }

}
