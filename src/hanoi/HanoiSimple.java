package src.hanoi;

import src.hanoi.modelo.Hanoi;

public class HanoiSimple {
    public static void main(String[] args) {
        /*
        HanoiSimple h =  new HanoiSimple();

        h.resolver(0,2,1,3);*/

        Hanoi h = new Hanoi(3);
        h.resolver(0,2,1);
    }

    private void resolver(int de, int a, int pp, int n) {
        if (n == 1) {
            System.out.println(de + " -> " + a);
            return;
        }
        resolver(de, pp, a, n-1);
        resolver(de, a, pp, 1);
        resolver(pp, a, de, n-1);
    }
}
