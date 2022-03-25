package src.recurrencia;

public class EjemploBasico {
    public static void main(String[] args) {

        EjemploBasico m = new EjemploBasico();

        System.out.println("Numeros de 1 a 10");
        m.numeros(10);
    }

    private void numeros(int i) {
        if (i == 1) {
            System.out.println(1);
            return;
        }
        int aImprimir = i;
        numeros(i-1);
        System.out.println(aImprimir);
    }
}
