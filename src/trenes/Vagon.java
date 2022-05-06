package trenes;

public class Vagon {
    private Object contenido;
    private Vagon siguiente;

    public Vagon(Object o) {
        contenido = o;
        siguiente = null;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public Vagon getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Vagon siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Vagon{"+ contenido +'}';
    }
}
