package listas;

public class Pila<E>  extends Lista<E> {

    public Pila() {
        super();
    }

    public void push(E o) {
        this.insertar(o);
    }

    public E pop() {
        E obj = raiz.getContenido();
        raiz = raiz.getSiguiente();

        return obj;
    }
}
