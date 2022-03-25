package src.mvc.modelo;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Automovil {
    private String marca;
    private Color color;
    private int tamano;
    private int x;
    private int y;
    private PropertyChangeSupport cambios;

    public Automovil(String marca, Color color, int tamano) {
        this.marca = marca;
        this.color = color;
        this.tamano = tamano;
        x = 20;
        y = 100;
        cambios = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener listener) {
        cambios.addPropertyChangeListener(listener);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public void dibujar(Graphics g) {
        g.setColor(color);

        // rectangulo principal y secundario
        g.fillRect(x, y + tamano, 4 * tamano, 2 * tamano);
        g.fillRect(x + tamano, y, 2 * tamano, tamano);
        // Ruedas
        g.fillOval(x + (int)(0.5 * (double)tamano),
                y + (int)(2.5 * (double)tamano),
                tamano, tamano);
        g.fillOval(x + (int)(2.5 * (double)tamano),
                y + (int)(2.5 * (double)tamano),
                tamano, tamano);
    }

    public void moverDerecha() {
        moverDerecha(5);
    }
    public void moverDerecha(int distancia) {
        int oldX = x;
        x += distancia;
        cambios.firePropertyChange("POSICION", oldX, x);
    }

    public void moverIzquierda() {
        int oldX = x;
        x -= 5;
        cambios.firePropertyChange("POSICION", oldX, x);
    }

    public void moverAnuimacion() {
        for(int i=0; i<50; i++) {
            moverDerecha(2);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
