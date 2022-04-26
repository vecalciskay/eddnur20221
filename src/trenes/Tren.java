package trenes;

public class Tren {
    private Vagon primero;

    public Tren() {
        primero = null;
    }

    public void insertar(Object o) {
        Vagon v = new Vagon(o);
        v.setSiguiente(primero);
        primero = v;
    }
}
