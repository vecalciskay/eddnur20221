package src.hanoi.modelo;

public class Anillo {
    private int tamano;

    public Anillo(int t) {
        tamano = t;
    }

    public int getTamano() {
        return tamano;
    }

    @Override
    public String toString() {
        return String.valueOf(tamano);
    }
}
