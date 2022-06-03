package arbol;

public class TestArbol {
    public static void main(String[] args) {
        Arbol<Integer> arbol = new Arbol<>();
        arbol.insertar(10, "1", null);

        arbol.insertar(4, "2", "1");
        arbol.insertar(5, "3", "1");
        arbol.insertar(7, "4", "1");

        arbol.insertar(2, "5", "2");
        arbol.insertar(99, "6", "2");
        arbol.insertar(3, "7", "2");

        arbol.insertar(100, "11", "7");

        arbol.insertar(3, "8", "4");

        arbol.insertar(2, "9", "8");
        arbol.insertar(7, "10", "8");

        System.out.println(arbol);
    }
}
