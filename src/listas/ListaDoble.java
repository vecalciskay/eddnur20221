package listas;

import java.util.Iterator;

public class ListaDoble<E> implements Iterable<E> {
    protected Nodo<E> raiz;
    protected Nodo<E> cola;

    protected int cantidad;

    public ListaDoble() {

        this.raiz = null;
        this.cola = null;
        cantidad = 0;
    }

    public void insertar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        nuevo.setSiguiente(raiz);
        if (raiz != null)
            raiz.setAnterior(nuevo);
        raiz = nuevo;
        if (cola == null)
            cola = raiz;
        cantidad++;
    }

    public void adicionar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        if (cola != null)
            cola.setSiguiente(nuevo);
        nuevo.setAnterior(cola);
        cola = nuevo;

        if (raiz == null)
            raiz = cola;

        cantidad++;
    }

    public E obtener(int pos) {
        Nodo<E> encontrado = getNodo(pos);
        if (encontrado == null)
            return null;
        return encontrado.getContenido();
    }

    public Nodo<E> getNodo(int pos) {
        if (raiz == null)
            return null;
        Nodo<E> actual;
        if (pos <= tamano() / 2) {
            int posActual = 0;
            actual = raiz;
            while (posActual < pos && actual != null) {
                actual = actual.getSiguiente();
                posActual += 1;
            }
        } else {
            int posActual = tamano() - 1;
            actual = cola;
            while (posActual > pos && actual != null) {
                actual = actual.getAnterior();
                posActual -= 1;
            }
        }
        return actual;
    }


    public Nodo<E> getRaiz() {
        return raiz;
    }

    private void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {
        if (raiz == null) {
            return "VACIA";
        }

        StringBuilder result = new StringBuilder();
        result.append("Lista: ");
        String separador = "";
        Nodo<E> actual = raiz;
        while (actual != null) {
            result.append(separador).append(actual);
            actual = actual.getSiguiente();
            separador = " <=> ";
        }

        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new IteradorLista<>(raiz);
    }

    public int tamano() {
        /*Nodo<E> actual = raiz;
        int resultado = 0;
        while(actual != null) {
            resultado++;
            actual = actual.getSiguiente();
        }
        return resultado;*/
        return this.cantidad;
    }

    public void eliminar(int pos) {

        if (pos < 0 || pos >= cantidad) {
            throw new ArrayIndexOutOfBoundsException("La lista solo tiene " + cantidad);
        }

        if (pos == 0) {
            raiz = raiz.getSiguiente();
            cantidad--;
            return;
        }
        if (pos == tamano() - 1) {
            cola = cola.getAnterior();
            cantidad--;
            return;
        }

        Nodo<E> actual = getNodo(pos);

        Nodo<E> siguiente = actual.getSiguiente();
        Nodo<E> anterior = actual.getAnterior();
        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);
        cantidad--;
    }

    static class Nodo<E> {
        private E contenido;
        private Nodo<E> siguiente;
        private Nodo<E> anterior;

        public Nodo(E contenido) {
            this.contenido = contenido;
            this.siguiente = null;
            this.anterior = null;
        }

        public E getContenido() {
            return contenido;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }

        public Nodo<E> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<E> anterior) {
            this.anterior = anterior;
        }

        @Override
        public String toString() {
            return "Nodo{" + contenido + '}';
        }
    }

    static class IteradorLista<E> implements Iterator<E> {

        private Nodo<E> actual;

        public IteradorLista(Nodo<E> r) {
            actual = r;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public E next() {
            E o = actual.getContenido();
            actual = actual.getSiguiente();
            return o;
        }
    }
}
