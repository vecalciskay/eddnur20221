package src.hanoi.modelo;

import java.util.Arrays;

public class Hanoi {
    private Barra[] barras;
    private int complejidad;
    
    public Hanoi(int n) {
        barras = new Barra[3];
        init(0,n);
        complejidad = n;
    }

    private void init(int i, int n) {
        for (int j = 0; j < 3; j++) {
            if (i == j){
                barras[i] = new Barra(n);
                continue;
            }
            barras[j] = new Barra();
        }
    }

    public void resolver(int de, int a, int pp) {
        resolverRecursivo(de,a,pp,complejidad);
    }

    private void resolverRecursivo(int de, int a, int pp, int n) {
        if (n == 1) {
            barras[a].colocar(barras[de].sacar());
            System.out.println(this);
            return;
        }
        resolverRecursivo(de, pp, a, n-1);
        resolverRecursivo(de, a, pp, 1);
        resolverRecursivo(pp, a, de, n-1);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append(barras[0]).append("\n");
        resultado.append(barras[1]).append("\n");
        resultado.append(barras[2]).append("\n");

        return resultado.toString();
    }
}
