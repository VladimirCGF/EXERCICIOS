package entities;

public class IngressoVIP extends Ingresso {

    public IngressoVIP() {
    }

    public IngressoVIP(double valor) {
        super();
        setValor(valor + 100);
    }

    @Override
    public double getValor() {
        return super.getValor();
    }

    @Override
    public void setValor(double valor) {
        super.setValor(valor);
    }
}
