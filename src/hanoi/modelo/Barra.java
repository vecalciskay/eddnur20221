package src.hanoi.modelo;

import java.util.Stack;

public class Barra {
    private Stack<Anillo> anillos;

    public Barra() {
        anillos = new Stack<Anillo>();
    }

    public Barra(int n) {
        //anillos = new Stack<Anillo>();
        this();

        for (int i = n; i > 0 ; i--) {
            anillos.push(new Anillo(i));
        }
    }

    public Anillo sacar() {
        return anillos.pop();
    }

    public void colocar(Anillo a) {
        anillos.push(a);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("|");
        for (Anillo a:anillos) {
            resultado.append("-").append(a);
        }
        return resultado.toString();
    }
}
