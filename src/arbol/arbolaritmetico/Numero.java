package arbol.arbolaritmetico;

public class Numero extends ElementoAritmetico{
    private double valor;

    public Numero(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
