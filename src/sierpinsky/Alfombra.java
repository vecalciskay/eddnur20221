package src.sierpinsky;

import java.awt.*;

public class Alfombra {

    private int xMain;
    private int yMain;
    private int complejidadMain;
    private int tamanoMain;

    public Alfombra() {
        xMain = 10;
        yMain = 10;
        complejidadMain = 1;
        tamanoMain = 243;
    }

    public int getxMain() {
        return xMain;
    }

    public void setxMain(int xMain) {
        this.xMain = xMain;
    }

    public int getyMain() {
        return yMain;
    }

    public void setyMain(int yMain) {
        this.yMain = yMain;
    }

    public int getComplejidadMain() {
        return complejidadMain;
    }

    public void setComplejidadMain(int complejidadMain) {
        this.complejidadMain = complejidadMain;
    }

    public void dibujar(Graphics g) {
        dibujarAlfombra(g, xMain, yMain, tamanoMain, complejidadMain);
    }

    private void dibujarAlfombra(Graphics g, int x, int y, int tamano, int complejidad) {
        if(complejidad == 1) {
            g.fillRect(x, y, tamano, tamano);
            return;
        }

        int newTamano = tamano / 3;
        int newComplejidad = complejidad - 1;

        dibujarAlfombra(g, x, y, newTamano, newComplejidad);
        dibujarAlfombra(g, x + newTamano, y, newTamano, newComplejidad);
        dibujarAlfombra(g, x + 2 * newTamano, y, newTamano, newComplejidad);
        dibujarAlfombra(g, x, y + newTamano, newTamano, newComplejidad);
        dibujarAlfombra(g, x + 2 * newTamano, y+ newTamano, newTamano, newComplejidad);
        dibujarAlfombra(g, x , y + 2*newTamano, newTamano, newComplejidad);
        dibujarAlfombra(g, x + newTamano, y + 2*newTamano, newTamano, newComplejidad);
        dibujarAlfombra(g, x + 2 * newTamano, y + 2*newTamano, newTamano, newComplejidad);
    }
}
