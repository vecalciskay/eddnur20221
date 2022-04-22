package src.paint.modelo;

import src.paint.vista.PaintPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;

public class Imagen {
    private PropertyChangeSupport cambios;
    protected int[][] pixeles;
    protected int ancho;
    protected int alto;

    public Imagen(int w, int h) {
        cambios = new PropertyChangeSupport(this);
        initImagen(w,h);
    }

    public Imagen(BufferedImage bi) {
        cambios = new PropertyChangeSupport(this);
        initImagen(bi);
    }

    private void initImagen(BufferedImage bi) {
        ancho = bi.getWidth();
        alto = bi.getHeight();

        pixeles = new int[ancho][alto];
        for (int j = 0; j < alto; j++) {
            for (int i = 0; i < ancho; i++) {
                int bgr = bi.getRGB(i, j);
                /*int red = (bgr >> 16) & 0x000000ff;
                int green = (bgr & 0x0000ff00);
                int blue = (bgr & 0x000000ff) << 16;
                pixeles[i][j] = blue | green | red;*/
                pixeles[i][j] = bgr;
            }
        }

        cambios.firePropertyChange("IMAGEN", 1, 0);
    }

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
        cambios.firePropertyChange("IMAGEN", 1, 0);
    }

    public void leerDeArchivo(String path) {
        BufferedImage bi = null;
        try {
            File f = new File(path);
            bi = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        initImagen(bi);
    }

    public void setColor(int c, int i, int j){
        pixeles[i][j] = c;
    }

    public void addObserver(PaintPanel paintPanel) {
        cambios.addPropertyChangeListener(paintPanel);
    }

    public void transformada() {
        cambios.firePropertyChange("IMAGEN", 1, 0);
    }
}
