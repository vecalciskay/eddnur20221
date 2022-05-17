package listas;

import java.util.Iterator;

public class Lista<E> implements Iterable<E> {
    protected Nodo<E> raiz;
    protected int cantidad;
    public Lista() {

        this.raiz = null;
        cantidad = 0;
    }

    public void insertar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        nuevo.setSiguiente(raiz);
        raiz = nuevo;
        cantidad++;
    }

    public void adicionar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);

        if (raiz == null) {
            raiz = nuevo;
            cantidad++;
            return;
        }

        Nodo<E> actual = raiz;
        while(actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(nuevo);
        cantidad++;
    }

    public E obtener(int pos) {
        if (pos == 0)
            return raiz.getContenido();

        int posActual = 0;
        Nodo<E> actual = raiz;
        while(posActual < pos && actual != null) {
            actual = actual.getSiguiente();
            posActual += 1;
        }

        return actual.getContenido();
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
        while(actual != null) {
            result.append(separador).append(actual);
            actual = actual.getSiguiente();
            separador = " -> ";
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

        if (pos < 0 || pos > cantidad) {
            throw new ArrayIndexOutOfBoundsException("La lista solo tiene " + cantidad);
        }

        if (pos == 0){
            raiz = raiz.getSiguiente();
            cantidad--;
            return;
        }

        Nodo<E> actual = raiz;
        int posActual = 0;
        while(posActual < (pos-1)) {
            posActual++;
            actual = actual.getSiguiente();
        }

        Nodo<E> siguienteDelSiguiente = actual.getSiguiente().getSiguiente();
        actual.getSiguiente().setSiguiente(null);
        actual.setSiguiente(siguienteDelSiguiente);
        cantidad--;
    }

    static class Nodo<E> {
        private E contenido;
        private Nodo<E> siguiente;

        public Nodo(E contenido) {
            this.contenido = contenido;
            this.siguiente = null;
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

        @Override
        public String toString() {
            return "Nodo{" + contenido +'}';
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
