package trenes;

public class TestTren {
    public static void main(String[] args) {
        Tren t = new Tren();
        t.insertar("Hugo");
        t.insertar("Paco");
        t.insertar("Luis");

        System.out.println(t);
    }
}
