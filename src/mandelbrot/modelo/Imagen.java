package src.mandelbrot.modelo;

import java.awt.*;

public class Imagen {
    protected int[][] pixeles;
    protected int ancho;
    protected int alto;

    public void dibujar(Graphics2D g) {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                g.setColor(new Color(pixeles[i][j]));
                g.drawLine(i,j,i,j);
            }
        }

    }

    public int[][] getPixeles() {
        return pixeles;
    }

    public void setPixeles(int[][] pixeles) {
        this.pixeles = pixeles;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void testImagen() {
        for (int i = 50; i < 100; i++) {
            for (int j = 50; j < 150; j++) {
                pixeles[i][j] = 0xff0000; // 255 * 256^2
            }
        }
    }

    protected void initImagen(int w, int h) {
        pixeles = new int[w][h];
        ancho = w;
        alto = h;
    }
}
