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

    @Override
    public String toString() {
        if (primero == null) {
            return "Tren vacio";
        }

        StringBuilder result = new StringBuilder();
        result.append("Tren: ");
        String separador = "";
        Vagon actual = primero;
        while(actual != null) {
            result.append(separador).append(actual);
            actual = actual.getSiguiente();
            separador = " -> ";
        }

        return result.toString();
    }
}
