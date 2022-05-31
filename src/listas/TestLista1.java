package listas;

import java.util.Iterator;

public class TestLista1 {
    public static void main(String[] args) {
        ListaDoble<String> l = new ListaDoble<>();

        l.insertar("Hugo");
        l.insertar("Paco");
        l.insertar("Luis");

        System.out.println(l);


        l.adicionar("Uno");
        l.adicionar("Dos");
        l.adicionar("Tres");

        System.out.println(l);

        for (int i = 0; i < l.tamano(); i++) {
            System.out.println("For " + i + ": " + l.obtener(i));
        }

        Iterator<String> iter = l.iterator();
        while(iter.hasNext()) {
            String elemento = iter.next();
            System.out.println("Iterador: " + elemento);
        }

        try {
            l.eliminar(6);
        } catch(Exception q) {
            System.out.println("No se puede eliminar: " + q.getMessage());
        }

        for (String s: l) {
            System.out.println("foreach: " + s);
        }

//        ListaOrdenada<String> lo = new ListaOrdenada<>();
//
//        lo.insertar("Hugo");
//        lo.insertar("Paco");
//        lo.insertar("Luis");
//        lo.insertar("Uno");
//        lo.insertar("Dos");
//        lo.insertar("Tres");
//
//        System.out.println(lo);
//
//        ListaOrdenada<Perro> p1 = new ListaOrdenada<>();
    }
}
