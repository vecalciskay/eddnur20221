package arbol.arbolaritmetico;

public class TestArbolAritmetico {
    public static void main(String[] args) {
        try {
            ArbolAritmetico arbol = new ArbolAritmetico("8 / ( ( ( 3.5 + 5 ) * 7 ) - 5.6 ) ");
            System.out.println(arbol);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
