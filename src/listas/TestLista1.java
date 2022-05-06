package listas;

public class TestLista1 {
    public static void main(String[] args) {
        Lista<String> l = new Lista();

        l.insertar("Hugo");
        l.insertar("Paco");
        l.insertar("Luis");

        System.out.println(l);


        l.adicionar("Uno");
        l.adicionar("Dos");
        l.adicionar("Tres");

        System.out.println(l);
    }
}
