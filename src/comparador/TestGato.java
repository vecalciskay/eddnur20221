package src.comparador;

import java.util.ArrayList;
import java.util.Comparator;

public class TestGato {
    public static void main(String[] args) {

        ArrayList<Gato> l = new ArrayList<>();

        l.add(new Gato(15, 4, "Hugo"));
        l.add(new Gato(5, 2, "Paco"));
        l.add(new Gato(10, 6, "Luis"));
        l.add(new Gato(12, 1, "Daisy"));

        l.sort((o1, o2) -> {
            if (o1.getEdad() < o2.getEdad())
                return -1;
            if (o1.getEdad() > o2.getEdad())
                return 1;
            return 0;
        });

        for (Gato g :
                l) {
            System.out.println(g);
        }
    }
}
