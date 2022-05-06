package listas;

public class Lista<E> {
    private Nodo<E> raiz;

    public Lista() {
        this.raiz = null;
    }

    public void insertar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        nuevo.setSiguiente(raiz);
        raiz = nuevo;
    }

    public void adicionar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);

        if (raiz == null) {
            raiz = nuevo;
            return;
        }

        Nodo<E> actual = raiz;
        while(actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(nuevo);
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
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
}