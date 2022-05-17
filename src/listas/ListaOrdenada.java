package listas;

public class ListaOrdenada<E extends Comparable> extends Lista<E> {

    public ListaOrdenada() {
        super();
    }

    @Override
    public void insertar(E o) {
        if (cantidad == 0 || o.compareTo(raiz.getContenido()) <= 0) {
            super.insertar(o);
            return;
        }

        Nodo<E> actual = raiz;
        while(actual.getSiguiente() != null) {
            if (actual.getSiguiente().getContenido().compareTo(o) > 0) {
                break;
            }
            actual = actual.getSiguiente();
        }

        Nodo<E> nuevo = new Nodo<>(o);
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        cantidad++;
    }
}
